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


//---OBJETO PERGUNTA
var questionQ = function objQuestion(questionQ, optionsQ, difficultyQ, authorQ, idQ) {

    this.question = questionQ;
    this.options = optionsQ;
    this.difficulty = difficultyQ;
    this.author = authorQ;
    this.id = idQ;

}

var questionQnoID = function objQuestion(authorQ, difficultyQ, optionsQ, questionQ) {

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

//MÉTODO DELETE API
function deleteQuestion(id) {

    fetch(linkFetch() + "/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to delete question');
            }
            return response.json();

        }).then(data => {
            console.log('Question deleted', data);
        }).catch(error => {
            console.error('Error:', error);

        });

}

//CONTRUIR QUESTÃO NOVA
function createQuestion() {

    var inpQuestion = document.getElementById("inputQuestion").value;

    function check() {
        var checkCorrect = [];
        var inpOptions = document.getElementsByName("options");
        for (var i = 0; i < inpOptions.length; i++) {
            checkCorrect[i] = inpOptions[i].checked;
        }
        return checkCorrect;
    }

    var checkOption = check();

    var options = [
        { answer: document.getElementById("opA").value, correct: checkOption[0] },
        { answer: document.getElementById("opB").value, correct: checkOption[1] },
        { answer: document.getElementById("opC").value, correct: checkOption[2] },
        { answer: document.getElementById("opD").value, correct: checkOption[3] }
    ];

    var inpLvl = parseInt(document.getElementById("level-input").value);
    var author = document.getElementById("author").value;

    var newQuestion = {
        question: inpQuestion,
        options: options,
        difficulty: inpLvl,
        author: author
    };

    return newQuestion;

}

//new question SUCCESS
function successQuestion(value) {

    container.innerHTML = '';
    form.style.display = "none";
    container.style.display = 'flex';

    if (value === true) {

        container.innerHTML = `
            <div id="message-question" class="new-question">
                <img src="../images/check.png" id="v-question" alt="correct">
                <h3>New question has been added to the list!</h3>
            </div>
        `;


    } else {

        container.innerHTML = `
            <div id="message-question" class="new-question">
                <img src="../images/close.png" id="x-question" alt="wrong">
                <h3>An error appear while processing the question..</h3>
            </div>
        `;

    }

}

//MÉTODO POST API
const submit = document.getElementById("post-question");

submit.addEventListener('click', () => {

    function areFieldsComplete() {
        let inpQuestion = document.getElementById("inputQuestion").value;
        let options = [
            document.getElementById("opA").value,
            document.getElementById("opB").value,
            document.getElementById("opC").value,
            document.getElementById("opD").value
        ];
        let levelInput = document.getElementById("level-input").value;
        let author = document.getElementById("author").value;

        if (!inpQuestion || !levelInput || !author) {
            return false;
        }

        for (let option of options) {
            if (!option) {
                return false;
            }
        }

        return true;
    }

    if (!areFieldsComplete()) {
        alert('Please fill all the fields before submitting.');
        return;
    }

    let nQ = createQuestion();

    fetch(linkFetch(), {

        method: 'POST',
        mode: 'cors',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nQ)

    }).then(response => response.json())
        .then(data => {
            console.log('Question', data);
            successQuestion(true);
        })
        .catch((error) => {
            console.error('Error submitting the form:', error);
            successQuestion(false);
        });

});

//
const form = document.getElementById("form");

//CONSTUIR QUESTÕES com butões de mostrar correta e eliminar questão
const container = document.getElementById('container');

function updQuestionsList(questions) {
    container.innerHTML = '';

    questions.forEach(question => {

        const questionBox = document.createElement('div');
        questionBox.classList.add('containerDiv');
        questionBox.dataset.questionId = question.id;

        const childOne = document.createElement('div');
        childOne.classList.add('childOne');
        questionBox.appendChild(childOne);

        const questionText = document.createElement('h1');
        questionText.textContent = question.question;
        questionText.classList.add('container-h1');
        childOne.appendChild(questionText);

        const optionsList = document.createElement('ul');
        question.options.forEach(option => {

            const optionItem = document.createElement('li');
            optionItem.textContent = option.answer;
            optionItem.classList.add('container-li');
            optionsList.appendChild(optionItem);

        });

        childOne.appendChild(optionsList);

        const childTwo = document.createElement('div');
        childTwo.classList.add('question-buttons');
        questionBox.appendChild(childTwo);

        const showCorrect = document.createElement('button');
        showCorrect.textContent = "Correct Option"
        showCorrect.classList.add('showCorrect');

        showCorrect.addEventListener('click', () => {

            question.options.forEach((option, index) => {

                if (option.correct) {
                    const optionItems = optionsList.querySelectorAll('li');
                    optionItems[index].classList.add('li-correct');
                }

            });

        });

        childTwo.appendChild(showCorrect);

        const elim = document.createElement('button');
        elim.textContent = "Delete Question";
        elim.classList.add('elim');

        elim.addEventListener('click', function () {

            const questionId = question.id;
            deleteQuestion(questionId);
            container.removeChild(questionBox);
            console.log(questionId);

        });

        childTwo.appendChild(elim);

        container.appendChild(questionBox);

    });

}

//fecth para a página questões
function fetchQuestionsList(num, rand) {

    const link = linkFetch(num);

    fetch(link).then(response => response.json()).then(data => {

        const questions = data.map(questionData => new questionQ(

            questionData.question,
            questionData.options,
            questionData.difficulty,
            questionData.author,
            questionData.id

        ));

        if (rand === false) {

            updQuestionsList(questions);

        } else {
            const rand = Math.floor(Math.random() * questions.length);
            const randQ = questions[rand];
            updQuestionsList([randQ]);
        }

    })

}

//Display settings
const level = document.getElementById('lvl');
const search = document.getElementById('src');
const all = document.getElementById('allQ');

all.addEventListener("click", () => {

    fetchQuestionsList(0, false);
    form.style.display = "none";
    container.style.display = "flex";

});

search.addEventListener("click", () => {

    var lvl = level.value;
    fetchQuestionsList(lvl, false);
    form.style.display = "none";
    container.style.display = "flex";

});

const add = document.getElementById("add");

add.addEventListener('click', () => {

    form.style.display = "flex";
    container.style.display = "none";

});

