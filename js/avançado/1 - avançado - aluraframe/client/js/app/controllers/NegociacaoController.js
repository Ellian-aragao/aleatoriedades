class NegociacaoController {

    constructor() {
        let $ = document.querySelector.bind(document)
        let formulario = $(".form")

        this._formData = formulario.data
        this._formQuantidade = formulario.quantidade
        this._formValor = formulario.valor


        this._listaNegociacoes = new ListaNegociacao()
        this._mensagem = new Mensagem()
        
        this._negociacaoView = new NegociacoesView($("#negociacoesView"))
        this._mensagemView = new MensagemView($('#mensagemView'))
        
        this._negociacaoView.update(this._listaNegociacoes)
        this._mensagemView.update(this._mensagem)
    }
    
    adiciona(event) {
        event.preventDefault()

        this._listaNegociacoes.adiciona(this._criaNegociacao())
        this._mensagem.texto = 'Negociação adicionada com sucesso'
        
        this._negociacaoView.update(this._listaNegociacoes)
        this._mensagemView.update(this._mensagem)

        this._limpaFormulario()
    }

    _criaNegociacao() {
        return (new Negociacao(
            new Date(DateHelper.stringToDate(this._formData.value)),
            this._formQuantidade.value,
            this._formValor.value
        ))
    }

    _limpaFormulario() {
        this._formData.value = ''
        this._formQuantidade.value = 1
        this._formValor.value = 0.0
        this._formData.focus()
    }
}
