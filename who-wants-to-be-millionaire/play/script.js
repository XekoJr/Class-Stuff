//---ALL SOUNDS
const mainTheme = document.getElementById('music');
mainTheme.volume = 0.2;
const sCorrect = document.getElementById('s-correct');
sCorrect.volume = 0.2;
const sWrong = document.getElementById('s-wrong');
sWrong.volume = 0.2;
const sSelected = document.getElementById('s-selected');
sSelected.volume = 0.2;
const sStart = document.getElementById('start');
sStart.volume = 0.2;
const lvl_1_5 = document.getElementById('lvl-1-5');
lvl_1_5.volume = 0.2;
const lvl_6_10 = document.getElementById('lvl-6-10');
lvl_6_10.volume = 0.2;
const lvl_11_13 = document.getElementById('lvl-11-13');
lvl_11_13.volume = 0.2;
const lvl_14_15 = document.getElementById('lvl-14-15');
lvl_14_15.volume = 0.2;

//---SOUND AND MUSIC
const sound = document.getElementById('sound');
const sOn = document.getElementById('sound-on');
const sOff = document.getElementById('sound-off');
let muted = true;

sound.addEventListener('click', () => {

    const audios = document.querySelectorAll('audio');
    const sOffDisplay = window.getComputedStyle(sOff).display;

    if (sOffDisplay === 'block') {

        sOff.style.display = 'none';
        sOn.style.display = 'block';

    } else {
        sOff.style.display = 'block';
        sOn.style.display = 'none';
    }

    audios.forEach(audio => {
        audio.muted = !muted;
    });

    muted = !muted;

});

//---LINK DE FETCH
const BASE_URL = "https://millionaire.filipecardeira.pt";

function linkFetch(num) {

    let url = BASE_URL + "/questions";

    if (num) {

        url += '?difficulty=' + num;

    }

    return url;

}

const container = document.getElementById('game-display');

//---OBJETO PERGUNTA
function objQuestion(authorQ, difficultyQ, optionsQ, questionQ) {
    this.question = questionQ;
    this.options = optionsQ;
    this.difficulty = difficultyQ;
    this.author = authorQ;
}

let countdown;

//---CRIA UMA PERGUNTA
function questionGame(questions) {
    container.innerHTML = ``;

    questions.forEach(question => {
        currentQuestion = question;

        //Criar div principal
        var questionGameDiv = document.createElement("div");
        questionGameDiv.classList.add("question-game");

        //Criar barra
        var backgroundImage = document.createElement("img");
        backgroundImage.src = "../images/question-bar.png";
        backgroundImage.classList.add("background-bar");
        backgroundImage.alt = "bar";
        questionGameDiv.appendChild(backgroundImage);

        //Criar h2
        var questionTitle = document.createElement("h2");
        questionTitle.textContent = question.question;
        questionGameDiv.appendChild(questionTitle);

        //Criar ul
        var optionsList = document.createElement('ul');
        optionsList.classList.add("questions-all");

        const letras = ['A', 'B', 'C', 'D'];
        question.options.forEach((option, index) => {

            //Criar li
            var answerLi = document.createElement('li');
            answerLi.classList.add("answer");

            //Criar barra
            var answerImage1 = document.createElement("img");
            answerImage1.src = "../images/question-bar.png";
            answerImage1.classList.add("background-bar");
            answerImage1.alt = "bar";

            //Criar gema
            var answerImage2 = document.createElement("img");
            answerImage2.src = "../images/gem.png";
            answerImage2.alt = "gem";

            // Criar h3
            var answerLetter = document.createElement("h3");
            answerLetter.textContent = letras[index];

            // Criar h4
            var answerText = document.createElement("h4");
            answerText.textContent = option.answer;

            answerLi.appendChild(answerImage1);
            answerLi.appendChild(answerImage2);
            answerLi.appendChild(answerLetter);
            answerLi.appendChild(answerText);

            // Adicionar li a ul
            optionsList.appendChild(answerLi);

            answerLi.addEventListener('click', function () {

                if (optionsList.classList.contains('answered')) {
                    return;
                }
                optionsList.classList.add('answered');

                lvl_1_5.pause();
                lvl_6_10.pause();
                lvl_11_13.pause();
                lvl_14_15.pause();

                answerLi.classList.add('answer-selected');
                sSelected.play();

                phone.style.pointerEvents = 'none';
                fifty.style.pointerEvents = 'none';

                clearInterval(countdown);

                setTimeout(function () {

                    if (option.correct) {

                        if (question.difficulty === 15) {

                            answerLi.classList.add('answer-correct');
                            answerLi.classList.remove('answer-selected');
                            sCorrect.play();
                            ans = true;
                            document.querySelector('#lose span').innerText = '1.000.000€';
                            endGame.style.display = 'block';

                        } else {

                            answerLi.classList.add('answer-correct');
                            answerLi.classList.remove('answer-selected');
                            sCorrect.play();
                            ans = true;
                            nextLvl.style.display = 'block';

                        }

                    } else {
                        answerLi.classList.add('answer-wrong');
                        answerLi.classList.remove('answer-selected');
                        sWrong.play();
                        ans = false;
                        endGame.style.display = 'block';
                        finalLevel = true;

                        question.options.forEach((option, index) => {

                            if (option.correct) {

                                const optionItems = optionsList.querySelectorAll('li');
                                optionItems[index].classList.add('answer-correct');

                            }

                        });

                    }

                }, 5000);

                optionsList.querySelectorAll('li').forEach(li => {
                    li.style.pointerEvents = 'none';
                });

            });

        });

        container.appendChild(questionGameDiv);
        container.appendChild(optionsList);

    });

}

//SHUFFLE OPS
function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}

//TIMMER 1m PARA RESPONDER
async function startTimer() {
    const timerDiv = document.createElement("div");
    timerDiv.classList.add("timer");
    document.body.appendChild(timerDiv);

    let timeLeft = 60;
    let timer;

    const timerFunction = () => {
        if (timeLeft >= 0) {
            timerDiv.textContent = `${timeLeft}`;
            timeLeft--;
            timer = setTimeout(timerFunction, 1000);
            const options = document.querySelectorAll('.answer');
            options.forEach(answer => {
                answer.addEventListener('click', () => {
                    clearTimeout(timer);
                    return;
                });
            });
        } else {
            timerDiv.textContent = "0";
            sWrong.play();
            disableOptions();
            endGame.style.display = 'block';
        }
    };

    timerFunction();

    await new Promise(resolve => setTimeout(resolve, 60000));
}

//DESATIVA OPÇÕES NÃO SELECIONADAS
function disableOptions() {

    const optionsLists = document.querySelectorAll(".questions-all");
    optionsLists.forEach(optionsList => {

        optionsList.classList.add("answered");
        optionsList.querySelectorAll("li").forEach(li => {

            li.style.pointerEvents = "none";

        });
    });

}

let currentQuestion;
//fecth para a página questões
function fetchQuestion(num, rand) {
    const link = linkFetch(num);

    fetch(link)
        .then(response => response.json())
        .then(data => {
            const questions = data.map(questionData => new objQuestion(
                questionData.author,
                questionData.difficulty,
                questionData.options,
                questionData.question
            ));

            if (rand === false) {
                questionGame(questions);
            } else {
                const randIndex = Math.floor(Math.random() * questions.length);
                const randQ = questions[randIndex];
                questionGame([randQ]);
                currentQuestion = randQ;
            }
        })
        .catch(error => console.error('Erro ao buscar as questões:', error));
}

//UPD TABLE LVL
function lvlTable(i) {

    if (i > 1) {

        let j = i - 1;
        let preTable = document.getElementById('lvl-' + j);
        preTable.classList.remove('cur-level');

        let prize = preTable.querySelector('h3').innerText;
        document.querySelector('#lose span').innerText = prize;
    }

    let curTable = document.getElementById('lvl-' + i);
    curTable.classList.add('cur-level');

}

//50:50 HELP
function useFiftyFifty() {
    const optionsList = document.querySelector('.questions-all');
    if (!optionsList) return;

    const options = Array.from(optionsList.querySelectorAll('li'));
    const wrongOptions = options.filter(option => {
        const optionText = option.querySelector('h4').textContent;
        return currentQuestion.options.some(opt => opt.answer === optionText && !opt.correct);
    });

    shuffleArray(wrongOptions);

    if (wrongOptions.length > 1) {
        wrongOptions[0].classList.add('answer-dnf');
        wrongOptions[0].style.pointerEvents = 'none';
        wrongOptions[1].classList.add('answer-dnf');
        wrongOptions[1].style.pointerEvents = 'none';
    }

    fifty.style.pointerEvents = 'none';
    fifty.classList.add('used');
}

//PHONE HELP
function usePhone() {
    const optionsList = document.querySelector('.questions-all');
    if (!optionsList) return;

    const options = Array.from(optionsList.querySelectorAll('li'));
    options.forEach(option => {

        const optionText = option.querySelector('h4').textContent;
        const isCorrect = currentQuestion.options.some(opt => opt.answer === optionText && opt.correct);

        if (!isCorrect) {
            option.classList.add('answer-dnf');
            option.style.pointerEvents = 'none';
        }

    });

    phone.style.pointerEvents = 'none';
    phone.classList.add('used');
}

//---SAVE THE DATA LOCALLY
function saveLevel(name, lvl) {

    const scoreData = {
        playerName: name,
        level: lvl
    };

    localStorage.setItem(name, JSON.stringify(scoreData));
}


const startGame = document.getElementById('play');
const divStartGame = document.getElementById('start-game');
const nextLvl = document.getElementById('next-question');
const endGame = document.getElementById('lose');
const table = document.getElementById('money-lvls');
table.style.display = 'none';
const menu = document.getElementById('level-menu');
const euros = document.getElementsByTagName('span');
const player = document.getElementById('player');
const help = document.getElementById('helps');
const fifty = document.getElementById('fifty');
let help50 = false;
const phone = document.getElementById('phone');
let helpPhone = false;
let currentLevel = 1;
let ans = false;
let finalLevel = false;
let playerName;

//FUNÇÃO PRINCIPAL
function playGame() {
    endGame.style.display = 'none';
    nextLvl.style.display = 'none';

    const audios = document.querySelectorAll('audio');
    audios.forEach(audio => {
        audio.muted = true;
    });

    mainTheme.play();

    startGame.addEventListener('click', async () => {

        playerName = player.value;
        if (playerName === '') {
            alert('Enter a name before beggining!');
            return;
        }
        console.log(playerName);

        mainTheme.pause();
        sStart.play();

        help.style.display = 'block';
        divStartGame.style.display = 'none';
        endGame.style.display = 'none';
        table.style.display = 'flex';
        lvlTable(currentLevel);
        fetchQuestion(currentLevel, true);

        lvl_1_5.play();

        await startTimer();

    });

    nextLvl.addEventListener('click', async () => {

        clearInterval(countdown);

        if (ans === true) {
            currentLevel++;

            if (!fifty.classList.contains('used')) {
                fifty.style.pointerEvents = 'auto';
            }

            if (!phone.classList.contains('used')) {
                phone.style.pointerEvents = 'auto';
            }

            lvlTable(currentLevel);
            fetchQuestion(currentLevel, true);
            nextLvl.style.display = 'none';
            ans = false;

            if (currentLevel >= 1 && currentLevel <= 5) {
                lvl_1_5.play();
            } else if (currentLevel >= 6 && currentLevel <= 10) {
                lvl_6_10.play();
            } else if (currentLevel >= 11 && currentLevel <= 13) {
                lvl_11_13.play();
            } else if (currentLevel >= 14 && currentLevel <= 15) {
                lvl_14_15.play();
            }

            await startTimer();

        } else {
            saveLevel(playerName, currentLevel);
            console.log(saveLevel);
        }

    });

    endGame.addEventListener('click', (event) => {
        event.preventDefault();

        if ((finalLevel === true) && (currentLevel == 16)) {
            saveLevel(playerName, 15);
        }

        if (finalLevel === true) {
            saveLevel(playerName, currentLevel - 1);
        }

        setTimeout(() => {
            window.location.href = "../highscore/index.html";
        }, 1000);

    });

    menu.addEventListener('click', () => {

        if (!table.classList.contains('clicked')) {
            table.style.height = '100vh';
            table.style.width = '100%';
            table.style.right = '0';
            table.classList.add('clicked');
        } else {
            table.classList.remove('clicked');
            table.style.height = '360px';
            table.style.width = '200px';
            table.style.right = '-250px';
        }

    });


    fifty.addEventListener('click', () => useFiftyFifty());
    phone.addEventListener('click', () => usePhone());

}



playGame();