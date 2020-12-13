package net.agten.heatersimulator.controller_modificat;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class TempControl {
    public static void main(String[] args) {
        String fileName = "src/net/agten/heatersimulator/controller_modificat/temp_controller.fcl";
        FIS fis = FIS.load(fileName, true);
        if (fis == null) {
            System.err.println("Can`t loadt filed: " + fileName);
            return;
        }

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("actualtemp", 0.0);
        fb.setVariable("referencetemp", 55.0);
        // Evaluate
        fb.evaluate();


        // Show output variable's chart
        fb.getVariable("powerCommand").defuzzify();

        System.out.println(fb);
        System.out.println("Power: " + fb.getVariable("powerCommand").getValue());

        JFuzzyChart.get().chart(fb);

        // Print ruleSet
        System.out.println(fb);
        System.out.println("Power: " + fb.getVariable("powerCommand").getValue());
    }
}
