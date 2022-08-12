package Polimorfismo;

public class TestPolimorfismo {
    public static void main(String[] args) {
        Operaciones op = new Oracle("DBOracle-USC");
        op.conectar();

        Operaciones op2 = new Postgres("DBPostgres-USC");
        op2.consultar();
    }
}
