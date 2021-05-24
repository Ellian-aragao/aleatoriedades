#include <iostream>

typedef const double CDouble;

#define COMPARTILHAMENTO_EM_SEQUENCIA char(4)

CDouble CLICK_POR_VISUALIZACAO = 0.12;                // de 100 visualizações, 12 resulta em clicks.
CDouble COMPARTILHAMENTO_POR_CLICK = 0.15;            // de 20 clicks, 3 resulta em compartilhamento.
CDouble VISUALIZACAO_POR_COMPARTILHAMENTO = 40.0;     // a cada compartilhamento gera-se 40 visualizações.
CDouble VISULIZACAO_ORIGINAL_POR_INVESTIMENTO = 30.0; // a cada real investido gera-se 30 visualizações.

inline double visualizacao_original_por_investimento(CDouble &investimento)
{
    return investimento * VISULIZACAO_ORIGINAL_POR_INVESTIMENTO;
}

inline double clicks_por_visualizacao(CDouble &visualizacao)
{
    return visualizacao * CLICK_POR_VISUALIZACAO;
}

inline double compartilhamentos_por_clicks(CDouble &clicks)
{
    return clicks * COMPARTILHAMENTO_POR_CLICK;
}

inline double compartilhamentos_por_visualizacao(CDouble &visualizacao)
{
    CDouble clickes_na_visualizacao = clicks_por_visualizacao(visualizacao);
    return compartilhamentos_por_clicks(clickes_na_visualizacao);
}

double acumulador_de_compartilhamentos(char iteration, CDouble &visualizacoes)
{
    return iteration <= 0
               ? visualizacoes
               : compartilhamentos_por_visualizacao(visualizacoes) + acumulador_de_compartilhamentos(--iteration, visualizacoes);
}

inline double quantidade_de_visualizacoes_do_compartilhamentos(CDouble &visualizacoes)
{
    return acumulador_de_compartilhamentos(COMPARTILHAMENTO_EM_SEQUENCIA - 1, visualizacoes);
}

inline double visualizacao_maxima_por_investimento(CDouble &investimento)
{
    CDouble visualizacoes = visualizacao_original_por_investimento(investimento);
    CDouble compartilhamentos = quantidade_de_visualizacoes_do_compartilhamentos(visualizacoes);
    return compartilhamentos;
}

inline double input_manual_usuario()
{
    double investimento = 0;
    std::cout << "Digite um valor de investimento (maior que zero): ";
    std::cin >> investimento;
    return investimento > 0 ? investimento : input_manual_usuario();
}

inline double recebe_input_do_usuario(const int &quantidade_de_argumentos, const char **argumentos)
{
    return quantidade_de_argumentos == 2
               ? std::stod(argumentos[1])
               : input_manual_usuario();
}

// #define TESTS
#ifndef TESTS

int main(const int argc, const char **argv)
{
    CDouble investimento = recebe_input_do_usuario(argc, argv);
    std::cout << "Máximo de pessoas: " << long(visualizacao_maxima_por_investimento(investimento)) << std::endl;
    return EXIT_SUCCESS;
}

#else

struct teste
{
    unsigned int aprovado = 0;
    unsigned int reprovado = 0;
};

struct teste teste;

inline bool assert_value(CDouble &expected, CDouble &actual)
{
    return (expected) == (actual) ? true : false;
}

inline void assert(CDouble &expected, CDouble &actual)
{
    if (assert_value(expected, actual))
    {
        teste.aprovado++;
        std::cout << "Aprovado: " << expected << " | " << actual << std::endl;
        return;
    }
    std::cout << "reprovado: " << expected << " | " << actual << std::endl;
    teste.reprovado++;
}

inline void show_results()
{
    std::cout << "aprovados: " << teste.aprovado << std::endl;
    std::cout << "reprovado: " << teste.reprovado << std::endl;
    std::cout << std::endl;
}

inline void teste_constantes()
{
    std::cout << "+ Constantes" << std::endl << std::endl;
    assert(12.0 / 100.0, CLICK_POR_VISUALIZACAO);
    assert(3.0 / 20.0, COMPARTILHAMENTO_POR_CLICK);
    assert(40, VISUALIZACAO_POR_COMPARTILHAMENTO);
    assert(30, VISULIZACAO_ORIGINAL_POR_INVESTIMENTO);
}

int main()
{
    std::cout << "********* TESTES *********" << std::endl;
    teste_constantes();
    std::cout << "--------------------------" << std::endl;
    show_results();
    return EXIT_SUCCESS;
}

#endif