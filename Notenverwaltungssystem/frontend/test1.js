// ===============================
//  API-BASISURL
// ===============================
const API_BASE = "http://localhost:8080/";

// ===============================
//  HILFSFUNKTIONEN
// ===============================
async function apiGet(path) {
    const response = await fetch(API_BASE + path);
    if (!response.ok) throw new Error("GET Fehler: " + response.status);
    return response.json();
}

async function apiPost(path, body) {
    const response = await fetch(API_BASE + path, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    });
    if (!response.ok) throw new Error("POST Fehler: " + response.status);
    return response.json();
}

async function apiPut(path, body) {
    const response = await fetch(API_BASE + path, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    });
    if (!response.ok) throw new Error("PUT Fehler: " + response.status);
    return response.json();
}

// ===============================
//  SCHÜLER LADEN (TABELLE)
// ===============================
async function loadStudents() {
    const tbody = document.querySelector("#students table tbody");
    tbody.innerHTML = "<tr><td colspan='4'>Lade...</td></tr>";

    try {
        const students = await apiGet("/students");
        tbody.innerHTML = "";

        students.forEach(s => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${s.id}</td>
                <td>${s.vorname} ${s.nachname}</td>
                <td>${s.klasse}</td>
                <td>
                    <button onclick="loadStudentGrades(${s.id})">Noten ansehen</button>
                </td>
            `;
            tbody.appendChild(row);
        });

    } catch (error) {
        tbody.innerHTML = "<tr><td colspan='4'>Fehler beim Laden!</td></tr>";
        console.error(error);
    }
}

// ===============================
//  SCHÜLER HINZUFÜGEN
// ===============================
async function addStudent(event) {
    event.preventDefault();

    const vorname = document.querySelector("#add-student input[name='vorname']").value;
    const nachname = document.querySelector("#add-student input[name='nachname']").value;
    const klasse = document.querySelector("#add-student input[name='klasse']").value;

    try {
        const result = await apiPost("/students", { vorname, nachname, klasse });
        alert("Schüler erfolgreich angelegt: " + result.id);
        loadStudents();
    } catch (error) {
        alert("Fehler beim Anlegen!");
        console.error(error);
    }
}

// ===============================
//  NOTEN LADEN
// ===============================
async function loadStudentGrades(studentId) {
    const gradeSection = document.querySelector("#grades");
    gradeSection.scrollIntoView({ behavior: "smooth" });

    const studentSelect = document.querySelector("#grades select[name='student']");
    studentSelect.innerHTML = `<option value="${studentId}">${studentId}</option>`;
}

// ===============================
//  NOTE SPEICHERN
// ===============================
async function saveGrade(event) {
    event.preventDefault();

    const studentId = document.querySelector("#grades select[name='student']").value;
    const fach = document.querySelector("#grades select[name='fach']").value;
    const note = document.querySelector("#grades input[name='note']").value;

    try {
        await apiPost(`/grades/${studentId}`, { fach, note });
        alert("Note erfolgreich gespeichert!");
    } catch (error) {
        alert("Fehler beim Speichern der Note!");
        console.error(error);
    }
}

// ===============================
//  EVENT-LISTENER REGISTRIEREN
// ===============================
document.addEventListener("DOMContentLoaded", () => {
    // Schülerliste laden
    loadStudents();

    // Formulare verbinden
    document.querySelector("#add-student form").addEventListener("submit", addStudent);
    document.querySelector("#grades form").addEventListener("submit", saveGrade);
});
