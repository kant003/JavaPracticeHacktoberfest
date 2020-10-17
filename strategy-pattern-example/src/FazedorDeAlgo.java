public class FazedorDeAlgo {

    FazAlgo fazAlgo;

    public FazedorDeAlgo() {
    }

    public void setFazAlgo(FazAlgo fazAlgo) {
        this.fazAlgo = fazAlgo;
    }

    public void fazerAlgo() {
        fazAlgo.fazAlgoDeManeiraEspecifica();
    }
}
