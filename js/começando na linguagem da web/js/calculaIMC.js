var pacientes = document.querySelectorAll(".paciente")
pacientes.forEach(paciente => {
    // calcula IMC dos pacientes iniciais
    paciente.querySelector(".info-imc").textContent = (paciente.querySelector(".info-peso").textContent / (paciente.querySelector(".info-altura").textContent * paciente.querySelector(".info-altura").textContent)).toFixed(2)
})

function calcImc(peso, altura) {
    return (peso / altura**2).toFixed(2)
}
