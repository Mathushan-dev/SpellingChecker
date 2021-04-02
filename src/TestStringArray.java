import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestStringArray {

    @SuppressWarnings("deprecation")
    @Test
    public void testConstructors() {
        StringArray arr1 = new StringArray();
        assertEquals(0, arr1.getAccSizeStringArray());
        assertEquals(100, arr1.getSizeStringArray());
        assertEquals(new String[100], arr1.getStringArray());

        StringArray arr2 = new StringArray(arr1);
        assertEquals(arr1.getAccSizeStringArray(), arr2.getAccSizeStringArray());
        assertEquals(arr1.getSizeStringArray(), arr2.getSizeStringArray());
        assertEquals(arr1.getStringArray(), arr2.getStringArray());
    }

    @Test
    public void testSize() {
        StringArray arr1 = new StringArray();
        assertEquals(0, arr1.size());
        arr1.add("0");
        assertEquals(1, arr1.size());
        arr1.add("1");
        assertEquals(2, arr1.size());
        for (int i = 0; i < arr1.getSizeStringArray(); i++) {
            arr1.set(i, "0");
        }
        assertEquals(100, arr1.getSizeStringArray());
    }

    @Test
    public void testIsEmpty() {
        StringArray arr1 = new StringArray();
        assertEquals(true, arr1.isEmpty());
        arr1.add("0");
        assertEquals(false, arr1.isEmpty());
    }

    @Test
    public void testGet() {
        StringArray arr1 = new StringArray();
        assertEquals(null, arr1.get(0));
        arr1.add("0");
        assertEquals("0", arr1.get(0));
        assertEquals(null, arr1.get(1));
    }

    @Test
    public void testSet() {
        StringArray arr1 = new StringArray();
        arr1.set(0, "0");
        assertEquals(null, arr1.get(0));
        arr1.set(1, "1");
        assertEquals(null, arr1.get(1));
        arr1.add("0");
        assertEquals( "0", arr1.get(0));
        arr1.set(0, "0b");
        assertEquals("0b", arr1.get(0));
        arr1.set(1, "1");
        assertEquals(null, arr1.get(1));
        arr1.add("1");
        assertEquals("1", arr1.get(1));
        arr1.set(1, "1b");
        assertEquals("1b", arr1.get(1));
        arr1.set(2, "2");
        assertEquals(null, arr1.get(2));

    }

    @Test
    public void testchangeSizeStringArray() {
        StringArray arr1 = new StringArray();
        arr1.changeSizeStringArray(true);
        assertEquals(200, arr1.getSizeStringArray());
        arr1.changeSizeStringArray(true);
        assertEquals(400, arr1.getSizeStringArray());
        arr1.changeSizeStringArray(false);
        assertEquals(200, arr1.getSizeStringArray());
        arr1.changeSizeStringArray(false);
        assertEquals(100, arr1.getSizeStringArray());
    }

    @Test
    public void testAdd() {
        StringArray arr1 = new StringArray();
        assertEquals(true, arr1.isEmpty());
        arr1.add("0");
        assertEquals(false, arr1.isEmpty());
        assertEquals("0", arr1.get(0));
        assertEquals(null, arr1.get(1));
        for (int i = 1; i < 75; i++) {
            arr1.add(String.valueOf(i));
        }
        assertEquals(100, arr1.getSizeStringArray());
        assertEquals(75, arr1.getAccSizeStringArray());
        arr1.add("75");
        assertEquals(200, arr1.getSizeStringArray());
        assertEquals(76, arr1.getAccSizeStringArray());
    }

    @Test
    public void testInsert(){
        StringArray arr1 = new StringArray();
        arr1.insert(1, "1");
        assertEquals(true, arr1.isEmpty());
        assertEquals(null, arr1.get(0));
        arr1.insert(0, "0");
        assertEquals(false, arr1.isEmpty());
        assertEquals("0", arr1.get(0));
        assertEquals(null, arr1.get(1));
        arr1.insert(1, "1");
        assertEquals("0", arr1.get(0));
        assertEquals(null, arr1.get(1));
        arr1.insert(0, "0b");
        assertEquals("0b", arr1.get(0));
        assertEquals("0", arr1.get(1));
        assertEquals(null, arr1.get(2));
        arr1.insert(1, "mid");
        assertEquals("0b", arr1.get(0));
        assertEquals("mid", arr1.get(1));
        assertEquals("0", arr1.get(2));
        assertEquals(null, arr1.get(3));
    }

    @Test
    public void testRemove() {
        StringArray arr1 = new StringArray();
        arr1.remove(0);
        assertEquals(true, arr1.isEmpty());
        arr1.add("0");
        assertEquals(false, arr1.isEmpty());
        arr1.remove(0);
        assertEquals(true, arr1.isEmpty());
        arr1.add("0");
        arr1.add("1");
        arr1.remove(1);
        assertEquals(false, arr1.isEmpty());
        assertEquals("0", arr1.get(0));
        arr1.remove(0);
        assertEquals(true, arr1.isEmpty());
        for (int i = 0; i <= 75; i++) {
            arr1.add(String.valueOf(i));
        }
        assertEquals(200, arr1.getSizeStringArray());
        for (int i = 0; i <= 26; i++) {
            arr1.remove(i);
        }
        assertEquals(100, arr1.getSizeStringArray());
        assertEquals(false, arr1.isEmpty());
    }

    @Test
    public void testContains(){
        StringArray arr1 = new StringArray();
        assertEquals(false, arr1.contains(null));
        assertEquals(false, arr1.contains("null"));
        arr1.add("0");
        assertEquals(true, arr1.contains("0"));
        arr1.add("hello");
        assertEquals(true, arr1.contains("HeLlo"));
    }

    @Test
    public void testContainsMatchingCase(){
        StringArray arr1 = new StringArray();
        assertEquals(false, arr1.containsMatchingCase(null));
        assertEquals(false, arr1.containsMatchingCase("null"));
        arr1.add("0");
        assertEquals(true, arr1.containsMatchingCase("0"));
        arr1.add("HeLlo");
        assertEquals(true, arr1.containsMatchingCase("HeLlo"));
        assertEquals(false, arr1.containsMatchingCase("heLlO"));
    }

    @Test
    public void testIndexOf(){
        StringArray arr1 = new StringArray();
        assertEquals(-1, arr1.indexOf("null"));
        assertEquals(-1, arr1.indexOf(null));
        arr1.add("0");
        assertEquals(0, arr1.indexOf("0"));
        arr1.add("HeLlo");
        assertEquals(1, arr1.indexOf("heLlo"));
    }

    @Test
    public void testIndexOfMatchingCase(){
        StringArray arr1 = new StringArray();
        assertEquals(-1, arr1.indexOfMatchingCase("null"));
        assertEquals(-1, arr1.indexOfMatchingCase(null));
        arr1.add("0");
        assertEquals(0, arr1.indexOfMatchingCase("0"));
        arr1.add("HeLlo");
        assertEquals(1, arr1.indexOfMatchingCase("HeLlo"));
        assertEquals(-1, arr1.indexOfMatchingCase("heLlo"));
    }
}
