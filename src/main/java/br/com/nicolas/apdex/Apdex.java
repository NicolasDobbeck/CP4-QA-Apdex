// NICOLAS DOOBECK MENDES - RM:557605

package br.com.nicolas.apdex;

public class Apdex {
    //Número total de solicitações, nesse caso o meu RM
    private final int totalSamples;
    private final int satisfactory;
    private final int tolerable;
    private final int frustrating;

    public Apdex(int satisfactory, int tolerable, int frustrating) {
        this.totalSamples = 557605;
        this.satisfactory = satisfactory;
        this.tolerable = tolerable;
        this.frustrating = frustrating;
    }

    //Fórmula para calcular o Apdex(Índice de Desempenho de Aplicativos)
    public double calculateApdex() {
        return (satisfactory + (tolerable / 2.0)) / totalSamples;
    }

    /*Categoriza a pontuação Apdex em
     uma das quatro classificações com
     base em uma tabela padrão do setor*/
    public String classifyApdex() {
        double score = calculateApdex();
        if (score >= 0.94) return "Excelente";
        else if (score >= 0.85) return "Bom";
        else if (score >= 0.70) return "Razoável";
        else if (score >= 0.50) return "Ruim";
        else return "Inaceitável";
    }

    public int getTotalSamples() {
        return totalSamples;
    }
}