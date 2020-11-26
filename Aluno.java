public class Aluno   {

    double  media, notaAprovacao = 5, notaRecuperacao;
    int     situacaoNota, Recuperacao, situacaoRecuperacao;

    public Aluno(){
        InvalidarSituacaoRecuperacao();
    }

    public void setNotaRecuperacao(double notaRecuperacao) {
        this.notaRecuperacao = notaRecuperacao;
    }
    public double getNotaRecuperacao() { return notaRecuperacao; }
    public int getSituacaoRecuperacao(){ return situacaoRecuperacao; }
    private void InvalidarSituacaoRecuperacao(){
        situacaoRecuperacao = -1;
    }

    public int calcularMediaAluno(double nota1, double nota2, double nota3) {
        if ((nota1 >= 0) && (nota2 >= 0) && (nota3 >=0) && (nota1 <= 10) && (nota2 <= 10) && (nota3 <= 10)) {
            media = (nota1 + nota2 + nota3) / 3;
            // calcular a nota do aluno
            if ((media >= 0) && (media < 4)) {
                situacaoNota = 5;
            } else if (media < 5) {
                situacaoNota = 4;
            } else if (media < 7) {
                situacaoNota = 3;
            } else if (media < 8) {
                situacaoNota = 2;
            } else if (media <= 10) {
                situacaoNota = 1;
            }
        }
              else {
                  situacaoNota = -1;
                System.out.println("Nenhuma nota do aluno pode ser negativa.\nNenhuma nota do aluno pode ser maior do que 10.");
            }
            return situacaoNota;
        }

    public int calcularRecuperacaoAluno(double nota1, double nota2, double nota3) {
        media = (nota1 + nota2 + nota3) / 3;

        if ((media >= 4) && (media <= 6)) {
            Recuperacao = 1;
        } else {
            Recuperacao = 0;
        }
        return Recuperacao;
    }

    public int calcularRecuperacaoAprovadoReprovado(double media) {
        if ((media >= 0) && (media <= 6.9)) {
            setNotaRecuperacao((getNotaRecuperacao() + media) / 2);
            if (getNotaRecuperacao() >= notaAprovacao) {
                situacaoRecuperacao = 0;
            } else if (getNotaRecuperacao() < notaAprovacao) {
                situacaoRecuperacao = 1;
                System.out.println("Aluno Reprovado.");
            }
        }
        else {
                System.out.println("Para calcular a nota de recuperação do aluno, a média informada não pode ser negativa ou maior do que 7.");
            }
        return getSituacaoRecuperacao();
    }


}



