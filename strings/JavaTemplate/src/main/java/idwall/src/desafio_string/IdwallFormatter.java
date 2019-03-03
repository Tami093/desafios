package desafio_string;

public class IdwallFormatter extends StringFormatter {

	   private static int CONSTANTE_0 = 0;
			private static int CONSTANTE_1 = 1;
			private static int CONSTANTE_2 = 2;
			private static int CONSTANTE_TAMANHO_LINHA = 40;
			private static String Texto_Formatado = "";

	    /**
	     * Should format as described in the challenge
	     *
	     * @param text
	     * @return
	     */
	    @Override
	    public String format(String text) {
	        
			primeiraParteString(text);
			Texto_Formatado+="\n\n\n";
			segundaParteString(text);
			
			return Texto_Formatado;

	    }
	    
	    private static void primeiraParteString(String texto) {
			int auxSairWhile = CONSTANTE_0, auxInicioDaString = CONSTANTE_0;
			int auxTamanhoAteVaiString = CONSTANTE_TAMANHO_LINHA;

			while (auxSairWhile != (texto.length() + CONSTANTE_1)) {
				if (auxTamanhoAteVaiString == texto.length()) {
					Texto_Formatado+=
							retiraEspacoComecoFimDaFrase(texto.substring(auxInicioDaString, auxTamanhoAteVaiString));
					auxSairWhile++;
				} else {
					if (texto.substring((auxTamanhoAteVaiString - CONSTANTE_1), auxTamanhoAteVaiString).equals(" ")
							|| texto.substring(auxTamanhoAteVaiString, (auxTamanhoAteVaiString + CONSTANTE_1)).equals(" ")) {
						Texto_Formatado+=
								retiraEspacoComecoFimDaFrase(texto.substring(auxInicioDaString, auxTamanhoAteVaiString));
					} else {
						auxTamanhoAteVaiString = retornoTamanhoFimDaString(auxTamanhoAteVaiString, texto);
						Texto_Formatado+=
								retiraEspacoComecoFimDaFrase(texto.substring(auxInicioDaString, auxTamanhoAteVaiString));
					}
					auxInicioDaString = auxTamanhoAteVaiString;
					auxTamanhoAteVaiString = verificaProximoTamanhoFinalString(texto, auxTamanhoAteVaiString);
					auxSairWhile = auxTamanhoAteVaiString;
					Texto_Formatado += "\n";
				}
			}
		}

		private static void segundaParteString(String texto) {
			int auxSairWhile = CONSTANTE_0, auxInicioDaString = CONSTANTE_0;
			int auxTamanhoAteVaiString = CONSTANTE_TAMANHO_LINHA;

			while (auxSairWhile != (texto.length() + CONSTANTE_1)) {
				if (auxTamanhoAteVaiString == texto.length()) {
					Texto_Formatado +=adicionaEspacosAMais(
							retiraEspacoComecoFimDaFrase(texto.substring(auxInicioDaString, auxTamanhoAteVaiString)));
					auxSairWhile++;
				} else {
					if (texto.substring((auxTamanhoAteVaiString - CONSTANTE_1), auxTamanhoAteVaiString).equals(" ")
							|| texto.substring(auxTamanhoAteVaiString, (auxTamanhoAteVaiString + CONSTANTE_1)).equals(" ")) {
						Texto_Formatado+=(adicionaEspacosAMais(
								retiraEspacoComecoFimDaFrase(texto.substring(auxInicioDaString, auxTamanhoAteVaiString))));
					} else {
						auxTamanhoAteVaiString = retornoTamanhoFimDaString(auxTamanhoAteVaiString, texto);
						Texto_Formatado+=(adicionaEspacosAMais(
								retiraEspacoComecoFimDaFrase(texto.substring(auxInicioDaString, auxTamanhoAteVaiString))));
					}
					auxInicioDaString = auxTamanhoAteVaiString;
					auxTamanhoAteVaiString = verificaProximoTamanhoFinalString(texto, auxTamanhoAteVaiString);
					auxSairWhile = auxTamanhoAteVaiString;
					Texto_Formatado += "\n";
				}
			}
		}

		/**Função para adicionar espaços a mais ate chegar o tamanho necessario.
		 * 
		 * @param texto Texto a ser lido
		 * @return texto
		*/
		private static String adicionaEspacosAMais(String texto) {
			int auxTamanhoString = texto.length();
			int inicioStr = CONSTANTE_0, fimStr = CONSTANTE_1;
			String auxStrIni = "", auxStrFin = "";
			
			while (texto.length() != CONSTANTE_TAMANHO_LINHA) {
				if (fimStr != auxTamanhoString) {
					if (texto.substring(inicioStr, fimStr).equals(" ")) {
						if (texto.substring(fimStr, fimStr + CONSTANTE_1).equals(" ")) {
							inicioStr += CONSTANTE_1;
							fimStr += CONSTANTE_1;
						} else {
							auxStrIni = texto.substring(CONSTANTE_0, fimStr);

							auxStrFin = texto.substring(fimStr, texto.length());

							texto = auxStrIni + " " + auxStrFin;
								
							inicioStr += CONSTANTE_2;
							fimStr += CONSTANTE_2;
							auxTamanhoString += CONSTANTE_1;
						}
					} else {
						inicioStr += CONSTANTE_1;
						fimStr += CONSTANTE_1;
					}
				} else {
					inicioStr = CONSTANTE_0;
					fimStr = CONSTANTE_1;
				}
			}
			return texto;
		}

		/**Função que retorna o tamanho a ser lido da string, sendo o cursor do final lido + o tamanho linha, ou o final do cursor mais oque é preciso ler.
		 * 
		 * @param texto texto a ser lido
		 * @param auxFinalTamnhoString altera este parametro para o novo final da string
		 * @return auxFinalTamnhoString
		 */
		private static int verificaProximoTamanhoFinalString(String texto, int auxFinalTamnhoString) {
			if (texto.length() > auxFinalTamnhoString + CONSTANTE_TAMANHO_LINHA) {
				auxFinalTamnhoString += CONSTANTE_TAMANHO_LINHA;
			} else {
				auxFinalTamnhoString += texto.length() - auxFinalTamnhoString;
			}
			return auxFinalTamnhoString;
		}

		/**Função recursiva retornando o ultimo espaço antes de quebrar a palavra.
		 * 
		 * @param tamanhoFim tamanho aonde esta localizado o char da palava quebrando-a
		 * @param texto Texto a ser lido
		 * @return tamanhoFim ja com o local do ultimo " " antes da palavra
		 */
		public static int retornoTamanhoFimDaString(int tamanhoFim, String texto) {
			if (texto.substring((tamanhoFim - CONSTANTE_1), tamanhoFim).equals(" ")) {
				return tamanhoFim;
			}
			return retornoTamanhoFimDaString(tamanhoFim - CONSTANTE_1, texto);
		}

		/**Função para retirar espaços que estarão no começo e/ou no fim da linha.
		 * 
		 * @param texto Texto a ser lido
		 * @return texto sem os espaços brancos
		 */
		public static String retiraEspacoComecoFimDaFrase(String texto) {
			if (texto.substring(CONSTANTE_0, CONSTANTE_1).equals(" ")) {
				texto = texto.substring(CONSTANTE_1, texto.length());
			}
			if (texto.substring(texto.length() - CONSTANTE_1, texto.length()).equals(" ")) {
				texto = texto.substring(CONSTANTE_0, texto.length() - CONSTANTE_1);
			}
			return texto;
		}

}
