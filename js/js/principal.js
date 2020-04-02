console.log("arquivo importado com sucesso")

function calcImc(paciente) {
    paciente.querySelector(".info-imc").textContent = (paciente.querySelector(".info-peso").textContent / (paciente.querySelector(".info-altura").textContent * paciente.querySelector(".info-altura").textContent)).toFixed(2)
}

// coleta os dados dos pacientes e faz o calculo do IMC
var pacientes = document.querySelectorAll(".paciente")
pacientes.forEach(calcImc)
// verifica se o botão foi clicado
document.querySelector("#adicionar-paciente").addEventListener("click", function(event) {
    event.preventDefault()
    var form = document.querySelector("#formularioDeAdicao")
    // salva os valores do formulario
    var nome    = form.nome.value
    var peso    = form.peso.value
    var altura  = form.altura.value
    var gordura = form.gordura.value
    // cria os elementos para serem injetados no HTML
    var linha     = document.createElement("tr")
    var nometd    = document.createElement("td")
    var pesotd    = document.createElement("td")
    var alturatd  = document.createElement("td")
    var gorduratd = document.createElement("td")
    var imctd     = document.createElement("td")
    // add classe nos itens do paciente
    linha.classList.add("paciente")
    nometd.classList.add("info-nome")
    pesotd.classList.add("info-peso")
    alturatd.classList.add("info-altura")
    gorduratd.classList.add("info-gordura")
    imctd.classList.add("info-imc")    
    // salva o conteúdo nas tags HTML
    nometd.textContent    = nome
    pesotd.textContent    = peso
    alturatd.textContent  = altura
    gorduratd.textContent = gordura    
    // add as colunas na linha da tabela
    linha.appendChild(nometd)
    linha.appendChild(pesotd)
    linha.appendChild(alturatd)
    linha.appendChild(gorduratd)
    linha.appendChild(imctd)
    // add a linha linha da tabela no HTML
    document.querySelector("#tabela-pacientes").appendChild(linha)
    // add o imc do novo paciente
    calcImc(linha)
})
