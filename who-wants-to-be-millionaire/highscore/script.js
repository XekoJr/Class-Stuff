//---SRC LEVEL DATA SAVED
function loadLevels() {
    const tableBody = document.getElementById('levelTableBody');

    const levelData = [];
    
    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        const storedData = localStorage.getItem(key);
        if (storedData) {
            const scoreData = JSON.parse(storedData);
            levelData.push(scoreData);
        }
    }

    levelData.sort((a, b) => b.level - a.level);

    levelData.forEach((data, index) => {
        const row = document.createElement('tr');

        const cellIndex = document.createElement('th');
        cellIndex.scope = "row";
        cellIndex.textContent = index + 1;
        cellIndex.classList.add('p-3');
        cellIndex.classList.add('mb-2');
        cellIndex.classList.add('bg-dark');
        cellIndex.classList.add('text-white')

        row.appendChild(cellIndex);

        const cellName = document.createElement('td');
        cellName.textContent = data.playerName;
        cellName.classList.add('p-3');
        cellName.classList.add('mb-2');
        cellName.classList.add('bg-dark');
        cellName.classList.add('text-white');

        row.appendChild(cellName);

        const cellLevel = document.createElement('td');
        cellLevel.textContent = data.level;
        cellLevel.classList.add('p-3');
        cellLevel.classList.add('mb-2');
        cellLevel.classList.add('bg-dark');
        cellLevel.classList.add('text-white')

        row.appendChild(cellLevel);

        tableBody.appendChild(row);
    });
}


loadLevels();