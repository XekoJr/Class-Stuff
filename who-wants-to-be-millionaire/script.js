//---NAV BAR
const close = document.getElementById("menu-close");
const open = document.getElementById("menu-open");
const navb = document.getElementsByTagName("nav");
const list = document.getElementById("nav-menu");

function toggleNavOn() {
    list.classList.add("nav-menu");
}

function toggleNavOff() {
    list.classList.remove("nav-menu");
}

function openMenu() {
    close.style.display = "block";
    open.style.display = "none";
    navb[0].style.height = "100vh";
    toggleNavOn();
}

function closeMenu() {
    close.style.display = "none";
    open.style.display = "block";
    navb[0].style.height = "55px";
    toggleNavOff();
}

open.addEventListener("click", openMenu);
close.addEventListener("click", closeMenu);

//---SOUNDS
const sound = document.getElementById('sound');
var music = document.getElementById('music');
music.volume = 0.15;
const sOn = document.getElementById('sound-on');
const sOff = document.getElementById('sound-off');

sound.addEventListener('click', () => {

    music.play();

    const sOffDisplay = window.getComputedStyle(sOff).display;

    if (sOffDisplay === 'block') {

        sOff.style.display = 'none';
        sOn.style.display = 'block';
        music.muted = false;

    } else {

        sOff.style.display = 'block';
        sOn.style.display = 'none';
        music.muted = true;

    }

})


//---OBJETO PERGUNTA
var questionQ = function objQuestion(questionQ, optionsQ, difficultyQ, authorQ) {

    this.question = questionQ;
    this.options = optionsQ;
    this.difficulty = difficultyQ;
    this.author = authorQ;

}

//---LINK DE FETCH
const BASE_URL = "https://millionaire.filipecardeira.pt";

function linkFetch(num) {

    let url = BASE_URL + "/questions";

    if (num) {

        url += '?difficulty=' + num;

    }

    return url;

}

//CONSTUIR QUESTÕES
function updQuestions(questions) {

    const container = document.getElementById('container');
    container.innerHTML = '';

    questions.forEach(question => {

        const questionBox = document.createElement('div');
        const questionText = document.createElement('h1');

        questionText.textContent = question.question;
        questionBox.appendChild(questionText);

        const optionsList = document.createElement('ul');

        question.options.forEach(option => {

            const optionItem = document.createElement('li');
            optionItem.textContent = option.answer;
            optionsList.appendChild(optionItem);

        });

        questionBox.appendChild(optionsList);
        container.appendChild(questionBox);

    });

}

//FECTCH DAS QUESTÕES --- Se 'rand' for falso mostra todas as questões do nivel, se for verdadeiro, escolhe uma questão random
function fetchQuestions(num, rand) {

    const link = linkFetch(num);

    fetch(link).then(response => response.json()).then(data => {

        const questions = data.map(questionData => new questionQ(

            questionData.question,
            questionData.options,
            questionData.difficulty,
            questionData.author

        ));

        if (rand === false) {

            updQuestions(questions);

        } else {
            const rand = Math.floor(Math.random() * questions.length);
            const randQ = questions[rand];
            updQuestions([randQ]);
        }

    })

}
