import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Declaração e instanciação dos objetos
        Paciente paciente1 = new Paciente("Maria Souza",  "10/10/1990", "999999999", "Ansiedade");
        Paciente paciente2 = new Paciente("Carlos Pereira", "20/05/1985", "888888888", "Depressão");

        Psicologo psicologo1 = new Psicologo("Ana Silva", "01/01/1980",  "777777777", "CRP-12345", "Terapia Cognitivo-Comportamental");
        Psicologo psicologo2 = new Psicologo("João Oliveira", "15/08/1978", "666666666", "CRP-67890", "Psicanálise");

        ClinicaPsicologica clinica1 = new ClinicaPsicologica("Clínica Bem-Estar");

        // Adicionando Psicólogos à Clínica
        clinica1.adicionarPsicologo(psicologo1);
        clinica1.adicionarPsicologo(psicologo2);

        // Exibindo informações dos pacientes
        System.out.println("---- Dados do paciente 1 ----");
        System.out.println("Nome: " + paciente1.getNome());
        System.out.println("Data de Nascimento: " + paciente1.getDataNascimento());
        System.out.println("Número: " + paciente1.getNumero());
        System.out.println("Motivo da Consulta: " + paciente1.getMotivoConsulta());

        System.out.println("\n---- Dados do paciente 2 ----");
        System.out.println("Nome: " + paciente2.getNome());
        System.out.println("Data de Nascimento: " + paciente2.getDataNascimento());
        System.out.println("Número: " + paciente2.getNumero());
        System.out.println("Motivo da Consulta: " + paciente2.getMotivoConsulta());

        // Modificando dados do paciente 1
        paciente1.setNome("Maria Silva Souza");
        paciente1.setDataNascimento("11/11/1991");
        paciente1.setNumero("987654321");
        paciente1.setMotivoConsulta("Ansiedade Generalizada");

        System.out.println("\n---- Dados do paciente 1 (após modificação) ----");
        System.out.println("Nome: " + paciente1.getNome());
        System.out.println("Data de Nascimento: " + paciente1.getDataNascimento());
        System.out.println("Número: " + paciente1.getNumero());
        System.out.println("Motivo da Consulta: " + paciente1.getMotivoConsulta());

        // Exibindo informações dos psicólogos
        System.out.println("\n---- Dados do psicólogo 1 ----");
        System.out.println("Nome: " + psicologo1.getNome());
        System.out.println("Data de Nascimento: " + psicologo1.getDataNascimento());
        System.out.println("Número: " + psicologo1.getNumero());
        System.out.println("CRP: " + psicologo1.getCrp());
        System.out.println("Especialidade: " + psicologo1.getEspecialidade());

        System.out.println("\n---- Dados do psicólogo 2 ----");
        System.out.println("Nome: " + psicologo2.getNome());
        System.out.println("Data de Nascimento: " + psicologo2.getDataNascimento());
        System.out.println("Número: " + psicologo2.getNumero());
        System.out.println("CRP: " + psicologo2.getCrp());
        System.out.println("Especialidade: " + psicologo2.getEspecialidade());

        // Modificando dados do psicólogo 2
        psicologo2.setNome("João dos Santos Oliveira");
        psicologo2.setDataNascimento("16/09/1979");
        psicologo2.setNumero("654321987");

        System.out.println("\n---- Dados do psicólogo 2 (após modificação) ----");
        System.out.println("Nome: " + psicologo2.getNome());
        System.out.println("Data de Nascimento: " + psicologo2.getDataNascimento());
        System.out.println("Número: " + psicologo2.getNumero());
        System.out.println("CRP: " + psicologo2.getCrp());
        System.out.println("Especialidade: " + psicologo2.getEspecialidade());

        // Exibindo informações da clínica
        System.out.println("\n---- Informações da clínica 1 ----");
        System.out.println("Nome: " + clinica1.getNome());


        // Modificando nome da clínica
        clinica1.setNome("Clínica Bem-Estar Total");

        System.out.println("\n---- Informações da clínica 1 (após modificação) ----");
        System.out.println("Nome: " + clinica1.getNome());


        // Agendando Consultas (demonstração)
        clinica1.agendarConsulta(psicologo1, paciente1, "10/10/2024", "15:00", "Agendada", "Online");
        clinica1.agendarConsulta(psicologo2, paciente2, "15/10/2024", "10:00", "Agendada", "Presencial");
    }
}

class Pessoa {
    protected String nome;
    protected String dataNascimento;
    protected String numero;

    public Pessoa(){
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

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
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

    // Getters para os atributos
    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters para os atributos (se necessário)
    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

class ClinicaPsicologica {
    private String nome;
    private List<Psicologo> psicologos;

    public ClinicaPsicologica(String nome) {
        this.nome = nome;
        this.psicologos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarPsicologo(Psicologo psicologo) {
        psicologos.add(psicologo);
    }

    public void agendarConsulta(Psicologo psicologo, Paciente paciente, String data, String hora, String status, String tipo) {
        Consulta consulta = new Consulta(psicologo, paciente, data, hora, status, tipo);
        psicologo.adicionarConsulta(consulta);
    }
}