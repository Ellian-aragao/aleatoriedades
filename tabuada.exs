defmodule Tabuada do
  def tabuada(multiplicador), do: tabuada(multiplicador, 1)
  def tabuada_list(multiplicador), do: tabuada(multiplicador, 1, [])
  defp tabuada(_, 11), do: nil

  defp tabuada(multiplicador, iteracao) do
    apresenta(multiplicador, iteracao)
    tabuada(multiplicador, iteracao + 1)
  end

  defp tabuada(_, 11, lista), do: lista

  defp tabuada(multiplicador, iteracao, lista) do
    multiplicado = apresenta(multiplicador, iteracao)
    tabuada(multiplicador, iteracao + 1, [multiplicado | lista])
  end

  defp apresenta( multiplicador, iteracao) do
    multiplicado = multiplicador * iteracao
    IO.puts("#{multiplicador} x #{iteracao} = #{multiplicado}")
    multiplicado
  end
end
