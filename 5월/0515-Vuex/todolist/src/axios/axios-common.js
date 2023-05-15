import axios from "axios";

//사용자 정의 axios 객체를 만드는 작업
export default axios.create({
    baseURL: "http://localhost", //중복되는 기본 URL을 지정
    headers: {
        "Content-Type" : "application/json"
    }
});