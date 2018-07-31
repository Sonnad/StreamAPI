package sp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {

        List<String> paths = new ArrayList<>();
        paths.add("src/main/resources/тст1.txt");
        paths.add("src/main/resources/тст2.txt");
        assertTrue(findQuoteResult.containsAll(SecondPartTasks.findQuotes(paths, "ipsum")));

        assertEquals(0, SecondPartTasks.findQuotes(paths, "john").size());
        
    }

    @Test
    public void testFindPrinter() {

        Map<String, List<String>> testMap = new HashMap<>();

        testMap.put("Test1", new ArrayList<String>() {{
            add("Colours to Life A Colours to Life Question Colours to Life Isn'tColours to Life  Answered Colours to Life Fragment's Light Fragment's Light Fragment's Light Fragment's Light");
        }});

        testMap.put("Test2", new ArrayList<String>() {{
            add("A Question Isn't Answered");
            add("Colours to Life");
            add("Fragment's Light");
            add("Jewel of Mine Eye");
            add("Keep in the Dark");
            add("Keep in the Dark22");
        }});

        testMap.put("Test3", new ArrayList<String>() {{
            add("A Question Isn't Answered1");
            add("Colours to Life2");
            add("Fragment's Light3");
            add("Jewel of Mine Eye4");
            add("Keep in the Dark5");
        }});

        testMap.put("Test4", new ArrayList<String>() {{
            add("A Question Isn't Answered");
            add("Colours to Life");
            add("Fragment's Light");
            add("Jewel of Mine Eye");
            add("Keep in the Dark");
            add("Keep in the Dark1");
        }});

        assertEquals("Test1", SecondPartTasks.findPrinter(testMap));

    }

    private List<String> findQuoteResult = new ArrayList<String>() {{
        add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");
        add("It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages.");
        add("More recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        add("Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC.");
    }};
}