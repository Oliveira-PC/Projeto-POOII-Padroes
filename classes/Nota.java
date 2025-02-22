package classes;

import java.util.ArrayList;

public class Nota implements NotaObserver {
private Double nota1;
private Double nota2;
private Double nota3;
private Double notaRecuperacao;
private boolean Status;
private ArrayList<Aluno> alunos = new ArrayList<>();
private ArrayList<Semestre> semestre = new ArrayList<>();

  public Nota(){
   this.nota1 = 0.0;
   this.nota2 = 0.0;
   this.nota3 = 0.0;
   this.notaRecuperacao = 0.0;
   this.Status = false;
  }


  public Nota(Double nota1, Double nota2, Double nota3, boolean Status) {
    this.nota1 = (nota1 != null) ? nota1 : 0.0;
    this.nota2 = (nota2 != null) ? nota2 : 0.0;
    this.nota3 = (nota3 != null) ? nota3 : 0.0;
    this.Status = false; 
}

public Double getNota1() {
  return this.nota1;
}

public void setNota1(Double nota1) {
  this.nota1 = nota1;
}

public Double getNota2() {
  return this.nota2;
}

public void setNota2(Double nota2) {
  this.nota2 = nota2;
}


public Double getNota3() {
  return this.nota3;
}

public void setNota3(Double nota3) {
  this.nota3 = nota3;
}

public boolean isStatus() {
    return Status;
}

public void setStatus(boolean Status) {
    this.Status = Status;
}

public double calcularMedia() {
  return (this.nota1 + this.nota2 + this.nota3)/ 3;
}
  

public boolean verificarSituacao() {
  boolean aprovado = false;
  double media = this.calcularMedia();

  if (media < 2.5) {
    System.out.println("Reprovado");
  } else if (media < 7) {
    System.out.println("Em recuperação");
  } else {
    System.out.println("Aprovado");
    aprovado = true;
  }

  return aprovado;
}

public void setNotaRecuperacao(double nota){
  this.notaRecuperacao = nota;
}

@Override
public String toString(){
  return this.nota1 + " , " + this.nota2 + " , " + this.nota3;
}

    public void atualizarStatusNota(boolean Status) {
        if (!Status) {
            this.Status = true;
            System.out.println("Nota foi bloqueada.");
        } else {
            this.Status = false;
            System.out.println("Nota está desbloqueada.");
        }
    }

    @Override
    public void atualizarStatusNota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
