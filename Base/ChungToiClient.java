import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


public class ChungToiClient {
	
	static int cp = 3;

	public static void main(String[] args) throws InterruptedException {
		try {
			ChungToiInterface p = (ChungToiInterface)Naming.lookup("//localhost/ChungToi");
			Scanner keyboard = new Scanner(System.in);
			int registro, partida,turno,pecaposicionada;
			
			while (true) {
				System.out.println("Informe o nome de usuário:");
				String nome = keyboard.next();
				System.out.println("Registrando jogador...");
				Thread.sleep(1000);
				registro = p.registraJogador(nome);
				if (registro == -2) {
					System.out.println("Número máximo de jogadores atingido!");
				}else if(registro == -1) {
					System.out.println("Usuário já cadastrado!\n");
				}else if(registro > 0){
					System.out.println("Usuário cadastrado com sucesso!");
					break;
				}
			}
			
			while (true) {
				System.out.println("Procurando partida...");
				Thread.sleep(2000);
				partida = p.temPartida(registro);
				if(partida==0) {
					System.out.println("Ainda não existe partida");
				}else if(partida == 1) {
					System.out.println("Existe partida e é o jogador 1");
					break;
				}else if(partida == 2) {
					System.out.println("Tem partida e é o jogador 2");
					break;
				}else if(partida == -2) {
					System.out.println("Tempo de espera por partida esgotado");
					break;
				}else if(partida == -1){
					System.out.println("Erro");
					break;
				}	
			}
			
			
			System.out.println("Seu oponente é: " + p.obtemOponente(registro));
			
			while (true) {
				Thread.sleep(2000);
				//verifica se é vencedor se sim turno vai para encerra partida, se não verifica se partida finalizada, se não executa o é minha vez.
				//não interessa quem é o vencedor porque vai para o encerra partida igual.
				turno = p.ehMinhaVez(registro);
				
				if(turno == -2) {
					System.out.println("Erro ainda não há dois jogadores registrados na partida");
				}else if(turno == -1) {
					System.out.println("Erro");
					break;
				}else if(turno == 0) {
					System.out.println("Vez do oponente");
				}else if(turno == 1) {
					System.out.println("É sua vez");
					System.out.println(p.obtemTabuleiro(registro));
					if(cp>=1) {
						System.out.println("Faltam " + cp + " peças para distribuir antes de iniciar o jogo");
						System.out.println("Defina uma posição para sua peça: (0-8)");
						int pos = keyboard.nextInt();
						System.out.println("Defina orientação da sua peça: (0-Perpendicular 1-Diagonal)");
						int orient = keyboard.nextInt();
						pecaposicionada = p.posicionaPeca(registro, pos, orient);
						if(pecaposicionada==2) {
							System.out.println("Partida Encerrada");
						}else if(pecaposicionada==1) {
							cp--;
						}else if(pecaposicionada==0) {
							System.out.println("Posição da peça inválida!");
						}else if(pecaposicionada==-1) {
							System.out.println("Parâmetros inválidos");
						}else if(pecaposicionada==-2) {
							System.out.println("Partida não iniciada");
						}else {
							System.out.println("Não é a vez do jogador");
						}
						
					}else {
						System.out.println("Mova sua peça");
						System.out.println("Defina posição do tabuleiro onde se encontra a peça que se deseja mover:(0-8)");
						int pos = keyboard.nextInt();
						System.out.println("Defina sentido do deslocamento: \n");
						System.out.println("0 - Esquerda Superior");
						System.out.println("2 - Direita Superior");
						System.out.println("3 - Esquerda");
						System.out.println("4 - Sem movimento");
						System.out.println("5 - Direito");
						System.out.println("6 - Esquerda Inferior");
						System.out.println("7 - Baixo");
						System.out.println("8 - Direita Inferior");
						int sent = keyboard.nextInt();
						System.out.println("Defina número de casas do deslocamento:(0-2) ");
						int numCasas = keyboard.nextInt();
						System.out.println("Defina orientação do deslocamento: (0-Perpendicular 1-Diagonal)");
						int orient = keyboard.nextInt();
						p.movePeca(registro, pos,sent, numCasas, orient);
					}
				}else if(turno == 2) {
					System.out.println("É o vencedor");
					p.encerraPartida(registro);
					break;
				}else if(turno == 3) {
					System.out.println("É o perdedor");
					p.encerraPartida(registro);
					break;
				}else if(turno == 4) {
					System.out.println("Houve empate");
					break;
				}else if(turno == 5) {
					System.out.println("Vencedor por WO");
					p.encerraPartida(registro);
					break;
				}else if(turno == 6) {
					System.out.println("Perdedor por W0");
					p.encerraPartida(registro);
					break;
				}
				
			}
			
			keyboard.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
