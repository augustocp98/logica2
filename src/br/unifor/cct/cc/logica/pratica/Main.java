package br.unifor.cct.cc.logica.pratica;

/**
 * 
 * @author Everton Guimaraes
 *
 */
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Boletim[] boletimAlunos = new Boletim[10];
		double[] mediaAlunos = new double[10];

		Registro(boletimAlunos, s);
		Imprimir(boletimAlunos, s);
		//Q5
		mediaAlunos = NotaMedia(boletimAlunos);
		//Q7
		imprimirMedia(boletimAlunos, mediaAlunos);
		//Q9
		buscarMatricula(boletimAlunos,s);

	}
	//Q1

	public static void Registro(Boletim[] boletimAlunos, Scanner s){

		for (int i = 0; i < boletimAlunos.length; i++) {

			Boletim boletim = new Boletim();
			System.out.println("Digite a matricula do aluno "+ i+1);
			boletim.matricula = s.nextInt();

			System.out.println("Digite o nome do aluno "+ i+1);
			boletim.nome = s.nextLine();

			System.out.println("Informe a nota 1 do aluno "+i+1);
			boletim.nota1 = s.nextDouble();

			System.out.println("Informe a nota 2: ");
			boletim.nota2 = s.nextDouble();

			System.out.println("Informe a nota 3: ");
			boletim.nota3 = s.nextDouble();

			boletimAlunos[i] = boletim;
		}


	}

	//Q2
	public static void Imprimir (Boletim[] boletimAlunos, Scanner s){
		int loop = 0;
		do{
			for(int i=0; i<boletimAlunos.length; i++){
				Boletim boletim = new Boletim();
				boletim = boletimAlunos[i];
				System.out.printf("%d\t",boletim.matricula +"%s\t\n",boletim.nome+"%2.2f  %2.2f  %2.2f", boletim.nota1, boletim.nota2, boletim.nota3);
			}
			System.out.println("Deseja imprimir novamente ? 1- Sim. 2- Não");
			loop = s.nextInt();
		}while(loop == 1);
	}

	//Q4
	public static double[] NotaMedia(Boletim[] boletimAlunos){

		double[] media = new double[boletimAlunos.length];

		for(int i=0; i<media.length; i++){
			media[i] = (boletimAlunos[i].nota1 + boletimAlunos[i].nota2 + boletimAlunos[i].nota3)/3;
		}

		return media;
	}

	//Q6
	public static void imprimirMedia(Boletim[] boletimAlunos,double[] mediaAlunos){
		for(int i=0; i<mediaAlunos.length; i++){
			System.out.printf("%s \t %2.2f",boletimAlunos[i].nome ,mediaAlunos[i]);
		}
	}

	//Q8
	public static void buscarMatricula(Boletim[] boletimAlunos, Scanner s){
		int procurada =0, aux =0;
		boolean encontrado = false;
		//Q10
		do{
			System.out.println("Informe a matricula que deseja verificar: ");
			procurada = s.nextInt();

			for(int i=0; i<boletimAlunos.length; i++){
				if(encontrado != true){


					if(procurada == boletimAlunos[i].matricula){
						encontrado = true;
						aux = i;
					}else{
						encontrado = false;
					}
				}

			}
			if(encontrado == true){
				System.out.println("True");
				//Q11
				System.out.println("Indice: " + aux);
			}else{
				System.out.println("False");
				//Q11
				System.out.println("-1");
			}
		}while(procurada != 0);
	}
	//Q11
	public static void buscarMatriculaII(Boletim[] boletimAlunos, Scanner s){
		int procurada =0, aux =0;
		boolean encontrado = false;
		String auxnome = null;
		double auxnota = 0;
		//Q13
		do{
			System.out.println("Informe a matricula que deseja verificar: ");
			procurada = s.nextInt();

			for(int i=0; i<boletimAlunos.length; i++){
				if(encontrado != true){


					if(procurada == boletimAlunos[i].matricula){
						encontrado = true;
						aux = i;
						//Q12
						auxnome = boletimAlunos[i].nome;
						auxnota = (boletimAlunos[i].nota1 + boletimAlunos[i].nota2 + boletimAlunos[i].nota3)/3; 
					}else{
						encontrado = false;
					}
				}

			}
			if(encontrado == true){
				System.out.println("Indice: " + aux);
				//Q12
				System.out.println("Nome: "+ auxnome);
				System.out.println("Media: "+ auxnota);
			}else{
				System.out.println("-1");
				//Q12
				System.out.println("Matricula invalida");
			}
		}while(procurada != 0);
	}


}

public class Boletim {
   public int matricula;
   public String nome;
   public double nota1;
   public double nota2;
   public double nota3;
}
