class ListaNegociacao {
    constructor(negociacaoView) {
        this._negociacoes = []
        this._negociacaoViewParameter = negociacaoView
    }
    
    get negociacoes() {
        return [].concat(this._negociacoes)
    }
    
    adiciona(negociacao) {
        this._negociacoes.push(negociacao)
        this._negociacaoViewParameter(this)
    }

    esvazia() {
        this._negociacoes = []
        this._negociacaoViewParameter(this)
    }
}
