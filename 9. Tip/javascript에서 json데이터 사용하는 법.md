### javascript에서 json데이터 사용하는 법

```javascript
var json = {
  "squadName": "Super hero squad",
  "homeTown": "Metro City",
  "formed": 2016,
  "secretBase": "Super tower",
  "active": true,
  "members": [
    {
      "name": "Molecule Man",
      "age": 29,
      "secretIdentity": "Dan Jukes",
      "powers": [
        "Radiation resistance",
        "Turning tiny",
        "Radiation blast"
      ]
    },
    {
      "name": "Madame Uppercut",
      "age": 39,
      "secretIdentity": "Jane Wilson",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ]
    },
    {
      "name": "Eternal Flame",
      "age": 1000000,
      "secretIdentity": "Unknown",
      "powers": [
        "Immortality",
        "Heat Immunity",
        "Inferno",
        "Teleportation",
        "Interdimensional travel"
      ]
    }
  ]
}

var superHeroes = json;
console.log(superHeroes.homeTown); //
console.log(superHeroes['active']);
console.log(superHeroes['members'][1]['powers'][2]);
```

Metro City
true
Superhuman reflexes



펌)

### 객체의 Properties의 접근법에는 위의 두가지가 있다.



#### 1. 점표기법(Dot notation)

```javascript
let obj = {
	cat: 'meow',
	dog: 'woof'
};

let sound = obj.cat; // objectName.propertyName;
console.log(sound); // meow
```

프로퍼티 식별자는 알파벳( **_** & **$** 포함)로 시작한다. 숫자로 시작할 수는 없다.

 



#### 2. 괄호표기법(Bracket Notation)

```javascript
let obj = {
	cat: 'meow',
	dog: 'woof'
};

let sound = obj.['cat']; // objectName["propertyName"]
console.log(sound); // meow
```

프로퍼티 식별자는 문자열(String)을 갖는다. 어떤 문자든 공백을 포함할수 있다.



```javascript
let obj = {
	cat: 'meow',
	dog: 'woof',
};

let dog = 'cat';			let dog = 'cat';
let sound = obj[dog];			let sound = obj.dog;

console.log(sound); // meow		console.log(sound); // woof
```

위의 예시와 비슷하지만, 주요한 차이점은 bracket notation을 통해 변수를 통과시킨다. 

obj 안에 있는 dog 프로퍼티를 찾는것 같지만, 여기서 dog는 'cat'의 값을 갖는다. 

bracket을 사용함으로써, 문자열값이 패스되고 'cat' 프로퍼티를 찾는다. obj["cat"] // meow

같은 예시에서 dot notation을 사용한다면 변수에 접근할 수 없기에 dog 변수의 값대신 dog 문자열의 값을 찾는다.





array 에서도 사용

```javascript
let arr = ['a', 'b', 'c'];

let letter = arr[1]; // objectName["propertyName"]

console.log(letter); // b
```











