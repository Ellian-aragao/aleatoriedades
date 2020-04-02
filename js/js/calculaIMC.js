function calcImc(paciente) {
    paciente.querySelector(".info-imc").textContent = (paciente.querySelector(".info-peso").textContent / (paciente.querySelector(".info-altura").textContent * paciente.querySelector(".info-altura").textContent)).toFixed(2)
}

// coleta os dados dos pacientes e faz o calculo do IMC
var pacientes = document.querySelectorAll(".paciente")
pacientes.forEach(calcImc)