function cube(val) {
    return val * val * val;
  }
  
  const foo = Math.PI * 2;
  var tommy = {
    num: 1,
    name: 'tommy lee',
    address: 'london',
  };
  // 다른 스크립트 파일에서 사용 가능하도록 선언
  export { cube, foo, tommy };
  
  export default {
    id: 100,
    name: 'harry',
    age: 13,
  };
  export function hello() {
    console.log('hello...');
  }