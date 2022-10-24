package io.github.kuberatest.actiongenerate;

public class ActionGeneratorTool {
    public static void main(String[] args) {
        ActionGenerator actionGenerator = new ActionGenerator();
        if (args.length > 1) {
            actionGenerator.setTestcaseExcelFilePath(args[1]);
        }
        actionGenerator.execute(args[0]);
    }
}