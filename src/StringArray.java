/**
 * A class that implements a String Array data structure.
 * @author Mathushan Mathiyalagan
 * @version 2021-01-29
 */
public class StringArray{
    /*sizeStringArray should be doubled when 75% full and halved when 25% full*/
    private int sizeStringArray, accSizeStringArray;
    private String[] stringArray;

    public StringArray(){
        this.sizeStringArray = 100;
        this.stringArray = new String[this.sizeStringArray];
        this.accSizeStringArray = 0;
    }

    public StringArray(StringArray a){
        this.sizeStringArray = a.getSizeStringArray();
        this.stringArray = a.getStringArray();
        this.accSizeStringArray = a.size();
    }

    public int getSizeStringArray(){
        return this.sizeStringArray;
    }

    public String[] getStringArray(){
        return this.stringArray;
    }

    public int getAccSizeStringArray(){
        return this.accSizeStringArray;
    }

    public int size(){
        for (int i = 0; i < this.sizeStringArray; i++){
            if (this.stringArray[i] == null){
                return i;
            }
        }
        return this.sizeStringArray;
    }

    public boolean isEmpty(){
        return this.stringArray[0] == null;
    }

    public String get(int index){
        if (index > this.sizeStringArray - 1 || index < 0){
            return null;
        }
        return this.stringArray[index];
    }

    public void set(int index, String s){
        if (index >= 0 && index <= this.sizeStringArray - 1 && this.stringArray[index] != null){
            this.stringArray[index] = s;
        }
    }

    public void changeSizeStringArray(boolean extend){
        if (extend){
            this.sizeStringArray = this.sizeStringArray * 2;
        }
        else{
            this.sizeStringArray = this.sizeStringArray / 2;
        }
        String[] newStringArray = new String[this.sizeStringArray];
        for (int i = 0; i < this.sizeStringArray; i++){
            if (this.stringArray[i] == null) {
                break;
            }
            newStringArray[i] = this.stringArray[i];
        }
        this.stringArray = newStringArray;
    }

    public void add(String s){
        if (this.accSizeStringArray >= 3 * (this.sizeStringArray / 4)){
            this.changeSizeStringArray(true);
        }
        this.stringArray[this.accSizeStringArray] = s;
        this.accSizeStringArray++;
    }

    public void insert(int index, String s){
        // Cannot insert to the end of existing elements in a list unless empty list special case
        if (index < 0 || index > this.sizeStringArray - 1 || (index > 0 && index == this.accSizeStringArray - 1)) {
            return;
        }
        if (this.accSizeStringArray >= 3 * (this.sizeStringArray / 4)){
            this.changeSizeStringArray(true);
        }
        System.arraycopy(this.stringArray, 0, this.stringArray, 0, index);
        System.arraycopy(this.stringArray, index, this.stringArray, index + 1, this.sizeStringArray - 1 - index);
        this.stringArray[index] = s;
        this.accSizeStringArray++;
    }

    public void remove(int index){
        if (index < 0 || index > this.accSizeStringArray) {
            return;
        }
        if (this.stringArray[index] == null) {
            return;
        }
        //Minimum array size of a 100
        if (this.sizeStringArray > 100 && this.accSizeStringArray <= this.sizeStringArray / 4){
            this.changeSizeStringArray(false);
        }
        System.arraycopy(this.stringArray, 0, this.stringArray, 0, index);
        System.arraycopy(this.stringArray, index + 1, this.stringArray, index, this.sizeStringArray - 1 - index);
        this.accSizeStringArray--;
    }

    public boolean contains(String s){
        for (int i = 0; i < this.sizeStringArray; i++){
            if (this.stringArray[i] != null){
                if (this.stringArray[i].equalsIgnoreCase(s)){
                    return true;
                }
            }
            else{
                break;
            }
        }
        return false;
    }

    public boolean containsMatchingCase(String s){
        for (int i = 0; i < this.sizeStringArray; i++){
            if (this.stringArray[i] != null){
                if (this.stringArray[i].compareTo(s) == 0){
                    return true;
                }
            }
            else{
                break;
            }
        }
        return false;
    }

    public int indexOf(String s){
        for (int i = 0; i < this.sizeStringArray; i++){
            if (this.stringArray[i] != null){
                if (this.stringArray[i].equalsIgnoreCase(s)){
                    return i;
                }
            }
            else{
                break;
            }
        }
        return -1;
    }

    public int indexOfMatchingCase(String s){
        for (int i = 0; i < this.sizeStringArray; i++){
            if (this.stringArray[i] != null){
                if (this.stringArray[i].compareTo(s) == 0){
                    return i;
                }
            }
            else{
                break;
            }
        }
        return -1;
    }
}
