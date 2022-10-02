package myproject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.kuberatest.e2e.Kubera;
import io.github.kuberatest.e2e.testcasereader.ExcelReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KuberaTemplateTest {

    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
        kubera.initialize();
    }

    @AfterEach
    public void tearDown() {
        kubera.close();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("excelTemplateTestcaseProvider")
    public void Excelファイルテンプレートを読み込んでテストを実行できる(String testCaseName, ArrayNode testCase) {
        for (JsonNode jsonNode: testCase) {
            kubera.action(jsonNode.toPrettyString());
        }
    }

    static Stream<Arguments> excelTemplateTestcaseProvider() {
        ExcelReader excelReader = new ExcelReader(KuberaTemplateTest.class.getResourceAsStream("/excelcase/kubera-template.xlsx"));
        return excelReader.readExcelFileToArgumentsStream();
    }
}
