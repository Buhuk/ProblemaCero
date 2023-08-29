public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("-- Problema de Ceros -- \n");

        // int[][] m1 = {{1,1,0,0,1,0},{0,1,0,0,1,1},{1,0,1,0,1,0},{0,0,1,0,0,1},{1,1,0,1,1,0},{0,0,1,1,0,1}};
        int[][] m1 = random();
        String[] pasos = {"","","","","",""};

        System.out.println("Original: ");
        mostrar(m1);

        System.out.println("Resuelto: ");
        mostrar(resolver(m1, pasos));

        System.out.println("Pasos: ");
        mostrar(pasos);

        System.out.println("Leyenda de pasos: ");
        System.out.println("A - Esta en un borde horizontal");
        System.out.println("B - Tiene un 1 abajo");
        System.out.println("C - Tiene un 1 arriba");
        System.out.println("D - Tiene un 1 en la izquierda");
        System.out.println("E - Tiene un 1 en la derecha");
        System.out.println("X - Se ha cambiado un 1 por un 0");
        System.out.println("0 - No ha habido cambios");
    }

    public static int[][] resolver(int[][] data, String[] pasos) {
        int[][] o = new int[6][6];

        for ( int i = 0; i < o.length; i++ ) {
            for ( int j = 0; j < o[i].length; j++ ) {
                if ( ( j == 0 || j == 5 ) && data[i][j] == 1 ) { // Los numeros en los bordes horizontales se dejan igual
                    o[i][j] = data[i][j];
                    pasos[i] += "A ";
                } else if ( data[i][j] == 0 ){
                    pasos[i] += "0 ";
                } else if ( ( i >= 0 && i < o.length-1 ) && data[i][j] == 1 &&  data[i+1][j] == 1 ){ // Si el numero de abajo es 1 se deja 1
                    o[i][j] = 1;
                    pasos[i] += "B ";
                } else if ( ( i > 0 && i < o.length ) && data[i][j] == 1 && data[i-1][j] == 1 ){ // Si el numero de arriba es 1 se deja 1
                    o[i][j] = 1;
                    pasos[i] += "C ";
                } else if ( data[i][j] == 1 && data[i][j-1] == 1 ){ // Si el numero de la izquierda es 1 se deja 1 
                    o[i][j] = 1;
                    pasos[i] += "D ";
                } else if ( data[i][j] == 1 && data[i][j+1] == 1 ){ // Si el numero de derecha es 1 se deja 1
                    o[i][j] = 1;
                    pasos[i] += "E ";
                } else {
                    pasos[i] += "X ";
                }
            }
        }
        return o;
    }

    public static int[][] random() {
        int[][] o = new int[6][6];
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o[i].length; j++) {
                o[i][j] = (int) (Math.random() * 2);
            }
        }
        return o;
    }
    public static void mostrar(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print( data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void mostrar(String[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println( data[i] + " ");
        }
        System.out.println();
    }

    public static int[][] clonar(int[][] data) {
        int[][] o = new int[6][6];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                o[i][j] = data[i][j];
            }
        }
        return o;
    }
}
