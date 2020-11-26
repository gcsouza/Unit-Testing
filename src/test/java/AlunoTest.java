import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Aluno.class)
public class AlunoTest {

    @Test
    public void calcularNotaAlunoTipoA(){
    //arrange
    Aluno aluno = new Aluno();
    int atual = 0;
    int esperado = 1;

    //act
    atual = aluno.calcularMediaAluno(10,9,8);

    //assert
    Assert.assertEquals(esperado, atual, 0);
  }

    @Test
    public void calcularNotaAlunoTipoB(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 2;

        //act
        atual = aluno.calcularMediaAluno(7,6,8);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularNotaAlunoTipoC(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 3;

        //act
        atual = aluno.calcularMediaAluno(5,4,8);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularNotaAlunoTipoD(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 4;

        //act
        atual = aluno.calcularMediaAluno(9,1,3);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularNotaAlunoTipoE(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 5;

        //act
        atual = aluno.calcularMediaAluno(3,1,5);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularRecuperacaoAlunoApto(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 1;

        //act
        atual = aluno.calcularRecuperacaoAluno(2,3,7);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularRecuperacaoAlunoInapto(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 0;

        //act
        atual = aluno.calcularRecuperacaoAluno(3,2,5);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularNota1AlunoMaiorQueDez(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularMediaAluno(11,10,7);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularNota2AlunoMaiorQueDez(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularMediaAluno(5,11,9);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularNota3AlunoMaiorQueDez(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularMediaAluno(4,10,11);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularMediaAlunoZerada(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 5;

        //act
        atual = aluno.calcularMediaAluno(0,0,0);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularMediaAlunoNotaDez(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = 1;

        //act
        atual = aluno.calcularMediaAluno(10,10,10);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularMediaAlunoNota1Negativa(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularMediaAluno(-7,5,9);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularMediaAlunoNota2Negativa(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularMediaAluno(3,-4,7);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularMediaAlunoNota3Negativa(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularMediaAluno(4,7,-8);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

    @Test
    public void calcularRecuperacaoAprovado() throws Exception {
        //arrange
        Aluno aluno = new Aluno();
        double atual = 0;
        double esperado = 0;
        final String METHOD = "getNotaRecuperacao";

        Aluno spy = PowerMockito.spy(aluno);
        PowerMockito.when(spy, METHOD).thenReturn((double)5.00);

        //act
        atual = spy.calcularRecuperacaoAprovadoReprovado(5);

        //assert
        Assert.assertEquals(esperado, atual, 0);

        PowerMockito.verifyPrivate(spy, Mockito.times(2)).invoke(METHOD);
    }

    @Test
    public void calcularRecuperacaoReprovado() throws Exception {
        //arrange
        Aluno aluno = new Aluno();
        double atual = 0;
        double esperado = 1;
        final String METHOD = "getNotaRecuperacao";

        Aluno spy = PowerMockito.spy(aluno);
        PowerMockito.when(spy, METHOD).thenReturn((double)4);

        //act
        atual = spy.calcularRecuperacaoAprovadoReprovado(5);

        //assert
        Assert.assertEquals(esperado, atual, 0);

        PowerMockito.verifyPrivate(spy, Mockito.times(3)).invoke(METHOD);
    }

    @Test
    public void calcularRecuperacaoNotaInvalida(){
        //arrange
        Aluno aluno = new Aluno();
        int atual = 0;
        int esperado = -1;

        //act
        atual = aluno.calcularRecuperacaoAprovadoReprovado(7);

        //assert
        Assert.assertEquals(esperado, atual, 0);
    }

}
