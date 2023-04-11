# 23.04.11
## 관통 pjt_알고리즘 활용
### 알고리즘 
- 관광지 정렬(sort)
  - Tim Sort = Insertion sort + Merge Sort (하이브리드 정렬)
- 검색 키워드 쿠키 저장 및 추천 알고리즘 => 트위터 공부하거나 생각해서 해보기
  - 저장된 개수(검색한 횟수)에 따라 가산점
  - 검색창 클릭 시 추천 키워드 제공
  - 로그인 접속 시 추천 키워드로 검색된 서비스 제공
- 암호화 알고리즘
  - 회원가입 했을때 암호화한 비밀번호로 유저 정보 저장
  - 로그인 할 때마다 비밀번호는 암호화해서 정보 전달
  - 암호화되어 전달된 비밀번호 정보와 DB에 저장된 유저 정보와 일치하면 로그인
  - SHA-256 혹은 BCrypt; BCrypt는 그냥 라이브러리 사용하면 됨


### 킹피티_추천 알고리즘
```java
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class KeywordRecommendation {

    private static final int MAX_KEYWORDS = 5; // 추천 키워드 최대 개수
    private static final int MAX_COOKIE_AGE = 30 * 24 * 60 * 60; // 쿠키 유효 시간 (30일)

    // 쿠키에서 검색 키워드 목록을 가져오는 메서드
    private static List<String> getKeywordsFromCookies(HttpServletRequest request) {
        List<String> keywords = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("keywords")) {
                    String[] keywordArray = cookie.getValue().split(",");
                    keywords = Arrays.asList(keywordArray);
                }
            }
        }
        return keywords;
    }

    // 검색 키워드 쿠키를 생성하는 메서드
    private static void createKeywordCookie(HttpServletResponse response, String keyword) {
        Cookie cookie = new Cookie("keywords", keyword);
        cookie.setMaxAge(MAX_COOKIE_AGE);
        response.addCookie(cookie);
    }

    // 추천 키워드를 생성하는 메서드
    private static List<String> generateRecommendedKeywords(List<String> keywords) {
        Map<String, Integer> keywordMap = new HashMap<>();
        for (String keyword : keywords) {
            if (keywordMap.containsKey(keyword)) {
                keywordMap.put(keyword, keywordMap.get(keyword) + 1); // 기존에 있는 키워드일 경우 가산점 부여
            } else {
                keywordMap.put(keyword, 1);
            }
        }

        // 가장 높은 가산점을 받은 키워드부터 추천
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(keywordMap.entrySet());
        sortedList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        List<String> recommendedKeywords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            if (recommendedKeywords.size() >= MAX_KEYWORDS) {
                break;
            }
            if (!keywords.contains(entry.getKey())) { // 검색한 키워드는 추천하지 않음
                recommendedKeywords.add(entry.getKey());
            }
        }
        return recommendedKeywords;
    }

    // 사용 예시
    public static void main(String[] args) {
        HttpServletRequest request = null; // 실제 서블릿에서는 request 객체를 사용
        HttpServletResponse response = null; // 실제 서블릿에서는 response 객체를 사용
        String searchedKeyword = "Java"; // 검색한 키워드

        List<String> keywords = getKeywordsFromCookies(request);
        keywords.add(searchedKeyword);
        createKeywordCookie(response, String.join(",", keywords));

        List<String> recommendedKeywords = generateRecommendedKeywords(keywords);
        System.out.println("Recommended Keywords: " + recommendedKeywords);
    }
}
```
### 킹피티_암호화 알고리즘_SHA-256
```java
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "userPassword123"; // 암호화할 비밀번호
        String salt = "randomSalt"; // 솔트
        
        String hashedPassword = hashPassword(password, salt); // 비밀번호 암호화
        
        // 암호화된 비밀번호와 솔트 출력
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt: " + salt);
    }
    
    // 비밀번호 해시 함수
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashedPassword);
    }
    
    // 바이트 배열을 16진수 문자열로 변환하는 메서드
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xff);
            if (hex.length() == 1) {
                sb.append("0");
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
```

### 킹피티_암호화 알고리즘_BCrypt
```java
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptionExample {
    public static void main(String[] args) {
        String password = "userPassword123"; // 암호화할 비밀번호
        String salt = BCrypt.gensalt(); // 솔트 생성
        
        String hashedPassword = BCrypt.hashpw(password, salt); // 비밀번호 암호화
        
        // 암호화된 비밀번호와 솔트 출력
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt: " + salt);
    }
}
```