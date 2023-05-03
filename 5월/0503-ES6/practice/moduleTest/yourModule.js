import { cube, foo, tommy } from './mymodule.js';
import { hello } from './mymodule.js';
import jane from './mymodule.js'; //default import

console.log(cube(3));
console.log(foo);
hello();
console.log(tommy.num, tommy.name, tommy.address);
console.log(jane.id, jane.name, jane.age);
