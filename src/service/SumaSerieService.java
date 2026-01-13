package service;

public class SumaSerieService {

    public StringBuilder generarProcedimiento(int n) {
        StringBuilder procedimiento = new StringBuilder();
        int suma = 0;

        for (int i = 1; i <= n; i += 4) {
            suma += i;
            procedimiento.append(i);

            if (i + 4 <= n) {
                procedimiento.append(" + ");
            }
        }

        procedimiento.append(" = ").append(suma);
        return procedimiento;
    }

    public int calcularSuma(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i += 4) {
            suma += i;
        }
        return suma;
    }
}
