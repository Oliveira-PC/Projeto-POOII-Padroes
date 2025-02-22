package classes;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
    
    String Nome;
    boolean Status;
    private List<NotaObserver> notas = new ArrayList<>();
    
    // Método para adicionar uma Nota (observadora)
    public void addObserver(NotaObserver observer) {
        notas.add(observer);
    }

    // Método para remover uma Nota (observadora)
    public void removeObserver(NotaObserver observer) {
        notas.remove(observer);
    }

    // Método para notificar todas as notas
    private void notifyObservers() {
        for (NotaObserver observer : notas) {
            observer.atualizarStatusNota();
        }
    }

    // Método para ativar ou desativar o semestre
    public void setStatus(boolean ativo) {
        this.Status = ativo;
        notifyObservers();
    }

    public List<NotaObserver> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaObserver> notas) {
        this.notas = notas;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public boolean isStatus() {
        return Status;
    }
    
    public Semestre(){
        
    }
    
    public Semestre( String Nome, boolean Status, List observers){
    this.Nome = Nome;
    this.Status = Status;
    this.notas = new ArrayList<>();
  }
    
}
