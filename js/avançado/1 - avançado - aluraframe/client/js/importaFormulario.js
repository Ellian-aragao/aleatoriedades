document.querySelector(".btn-primary").addEventListener('click', event => {
    event.preventDefault()
    formulario = document.querySelector(".form")
    dadosNegociacao = importaValoresFormulario(formulario)
    adicionaLinhaNaTabela(criaTr(dadosNegociacao))
})

function adicionaLinhaNaTabela(linha) {
    tabela = document.querySelector(".conteudo-tabela")
    tabela.appendChild(linha)
}

function criaTr(negociacao) {
    linha = document.createElement("tr")
    linha.classList.add("negociation")
    linha.appendChild(criaTd("info-data" ,negociacao.data))
    linha.appendChild(criaTd("info-quantidade" ,negociacao.quantidade))
    linha.appendChild(criaTd("info-valor" ,negociacao.valor))
    linha.appendChild(criaTd("info-volume" ,negociacao.volume))
    return linha
}

function criaTd(className, value) {
    celula = document.createElement("td")
    celula.classList.add(className)
    celula.textContent = value
    return celula
}

function importaValoresFormulario(formulario) {
    var negociacao = {
        data: formulario.data.value,
        quantidade: formulario.quantidade.value,
        valor: formulario.valor.value,
        volume: (formulario.valor.value * formulario.quantidade.value)
    }
    return negociacao
}
