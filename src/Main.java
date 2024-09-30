import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando Pacientes
        Paciente paciente1 = new Paciente("Maria Souza", "10/10/1990", "999999999", "Ansiedade");
        Paciente paciente2 = new Paciente("Carlos Pereira", "20/05/1985", "888888888", "Depressão");

        // Criando Psicólogos
        Psicologo psicologo1 = new Psicologo("Ana Silva", "01/01/1980", "777777777", "CRP-12345", "Terapia Cognitivo-Comportamental");
        Psicologo psicologo2 = new Psicologo("João Oliveira", "15/08/1978", "666666666", "CRP-67890", "Psicanálise");

        // Agendando Consultas
        psicologo1.agendarConsulta(paciente1, "10/10/2024", "15:00", "Agendada", "Online");
        psicologo2.agendarConsulta(paciente2, "15/10/2024", "10:00", "Agendada", "Presencial");

        // Exibindo informações dos pacientes e consultas
        System.out.println("\n---- Dados do paciente 1 ----");
        System.out.println(paciente1);
        for (Consulta consulta : psicologo1.getConsultas()) {
            if (consulta.getPaciente() == paciente1) {
                consulta.exibirInformacoes();
            }
        }

        System.out.println("\n---- Dados do paciente 2 ----");
        System.out.println(paciente2);
        for (Consulta consulta : psicologo2.getConsultas()) {
            if (consulta.getPaciente() == paciente2) {
                consulta.exibirInformacoes();
            }
        }

        // Modificando dados do paciente 1
        paciente1.setNome("Maria Silva Souza");

        System.out.println("\n---- Dados do paciente 1 (após modificação) ----");
        System.out.println(paciente1);

        // Exibindo informações dos psicólogos
        System.out.println("\n---- Dados do psicólogo 1 ----");
        System.out.println(psicologo1);

        System.out.println("\n---- Dados do psicólogo 2 ----");
        System.out.println(psicologo2);

        // Modificando dados do psicólogo 2
        psicologo2.setNome("João dos Santos Oliveira");

        System.out.println("\n---- Dados do psicólogo 2 (após modificação) ----");
        System.out.println(psicologo2);
    }
}

class Pessoa {
    protected String nome;
    protected String dataNascimento;
    protected String numero;

    public Pessoa() {
        nome = "Jorge";
        dataNascimento = "01/01/1999";
        numero = "12345";
    }

    public Pessoa(String nome, String dataNascimento, String numero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

class Psicologo extends Pessoa {
    private String crp;
    private String especialidade;
    private List<Consulta> consultas;

    public Psicologo(String nome, String dataNascimento, String numero, String crp, String especialidade) {
        super(nome, dataNascimento, numero);
        this.crp = crp;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultas(){
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas){
        this.consultas = consultas;
    }

    public void agendarConsulta(Paciente paciente, String data, String hora, String status, String tipo) {
        Consulta consulta = new Consulta(this, paciente, data, hora, status, tipo);
        this.consultas.add(consulta);
    }

    @Override
    public String toString() {
        return "Psicólogo: " + nome +
                "\nData de Nascimento: " + dataNascimento +
                "\nNúmero: " + numero +
                "\nCRP: " + crp +
                "\nEspecialidade: " + especialidade +
                "\nConsultas agendadas: " + consultas.size();
    }
}

class Paciente extends Pessoa {
    private String motivoConsulta;

    public Paciente(String nome, String dataNascimento, String numero, String motivoConsulta) {
        super(nome, dataNascimento, numero);
        this.motivoConsulta = motivoConsulta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    @Override
    public String toString() {
        return "Paciente: " + nome +
                "\nData de Nascimento: " + dataNascimento +
                "\nNúmero: " + numero +
                "\nMotivo da Consulta: " + motivoConsulta;
    }
}

class Consulta {
    private Psicologo psicologo;
    private Paciente paciente;
    private String data;
    private String hora;
    private String status; // Ex: "Agendada", "Realizada", "Cancelada"
    private String tipo; // Ex: "Presencial", "Online"

    public Consulta(Psicologo psicologo, Paciente paciente, String data, String hora, String status, String tipo) {
        this.psicologo = psicologo;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.tipo = tipo;
        System.out.println("Consulta " + tipo + " agendada com sucesso com o(a) Dr(a). " + psicologo.getNome() +
                " para " + paciente.getNome() + " em " + data + " às " + hora + ".");
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }


    // Método para exibir informações da consulta
    public void exibirInformacoes() {
        System.out.println("  Dados da Consulta:");
        System.out.println("    Psicólogo: " + psicologo.getNome());
        System.out.println("    Paciente: " + paciente.getNome());
        System.out.println("    Data: " + data);
        System.out.println("    Hora: " + hora);
        System.out.println("    Status: " + status);
        System.out.println("    Tipo: " + tipo);
    }
}