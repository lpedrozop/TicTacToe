public class score {

    private int ID;
    private String usuario;

    private String usuario2;
    private int puntaje;
    private int partidasg;
    private int partidasp;
    private int partidase;
    private int totalp;
    private String time;
    private String na;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }
    public String getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(String usuario2) {
        this.usuario2 = usuario2;
    }


    public int getPartidasg() {
        return partidasg;
    }

    public void setPartidasg(int partidasg) {
        this.partidasg = partidasg;
    }

    public int getPartidasp() {
        return partidasp;
    }

    public void setPartidasp(int partidasp) {
        this.partidasp = partidasp;
    }

    public int getPartidase() {
        return partidase;
    }

    public void setPartidase(int partidase) {
        this.partidase = partidase;
    }

    public int getTotalp() {
        return totalp;
    }

    public void setTotalp(int totalp) {
        this.totalp = totalp;
    }



    public int getId (){ return ID; }
    public void setId(int ID){
        this.ID = ID;
    }
    public String getUsuario (){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public int getPuntaje (){
        return puntaje;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

}
