# Arrays

1. ## What is an Array?
   - An array is a data structure that stores a `collection of elements`, each identified by an `index` or a key.
   - Arrays provide a way to organize and manage a group of items of the same data type.
   - They are used extensively in programming for tasks such as `storing` and `accessing` multiple values efficiently.

<hr />
<hr />

2. ## Basic Concepts:
   1. **`Indexing`**: Elements in an array are <u>accessed using their index</u>, which usually starts from `0` and goes up to `length - 1`.

   2. **`Fixed Size`**: Arrays have a fixed size, meaning you need to <u>define the size when creating an array</u>. This size remains constant throughout the array's lifetime. Unles, the array is dynamic.

   3. **`Homogeneous Elements`**: All elements in an array must be of the <u>same data type</u>.

   4. **`Operations on Arrays`**:
      1. **`Initialization`**: Creating an array and assigning values to its elements.
      2. **`Access`**: Retrieving elements from specific positions using their indices.
      3. **`Insertion`**: Adding elements at the end or a specific position in the array.
      4. **`Deletion`**: Removing elements from the array.
      5. **`Update`**: Modifying the value of an element at a given index.
      6. **`Traversal`**: Visiting each element in the array.
      7. **`Searching`**: Finding the index of a specific value in the array
      8. **`Sorting`**: Arranging elements in a specific order.
      9. **`Copying`**: Creating a copy of an array.

<hr />
<hr />

3. ## Arrays in Java:

    1. ### Single Dimensional Array
        1. #### Array Declaration and Initialization:

            - When an array is declared, only a reference of an array is created. To create or give memory to the array, we create an array using `new` keyword.
            - The elements in the array allocated by `new` will automatically be initialized to the `dataType's default value`.
            - Thus, in Java, all arrays are `dynamically allocated`.
            ```java
            // Declare an array
            dataType[] arrayName;
            // or
            dataType arrayName[];
            // or
            dataType []arrayName;

            // Assigning size to the array / allocating memory to array.
            arrayName = new dataType[size];
            ```
            ##### Array Literal
            ```java
            // Alternatively, we can combine declaration and initialization
            dataType[] arrayName = { value1, value2, ..., valueN };
            // or
            dataType[] arrayName = new dataType[]{ value1, value2, ..., valueN }; 
            ```

        2. #### Accessing Array:
            Array elements are accessed using their `index`, which starts from `0` and goes up to `array.length - 1`.<br />
            For example:
            ```java
            int[] numbers = { 1, 2, 3, 4, 5 };
            int firstNumber = numbers[0]; // Accessing the first element (1)
            ```

        3. #### Array Length:
            The length of an array can be obtained using the `length` instance variable:<br />
            For example:
            ```java
            int[] numbers = { 1, 2, 3, 4, 5 };
            int length = numbers.length; // Gives the length of the 'numbers' array (5)
            ```

    <hr />

    2. ### Multi Dimensional Array
       - Multidimensional arrays are arrays of arrays with each element of the array holding the `reference` of other arrays.
       - A multidimensional array is created by appending one set of square brackets (`[]`) per dimension.
       1. #### Array Declaration and Initialization:
            ```java
            // Declare an array
            dataType[][] arrayName;
            // or
            dataType arrayName[][];

            // Assigning size to the array / allocating memory to array.
            arrayName = new dataType[size];
            ```

    <hr />

    3. ### Jagged Arrays:
       A jagged array is an array of arrays such that member arrays can be of `different sizes`, i.e., we can create a 2-D array but with a ___variable number of columns in each row___.
       1. #### Array Declaration and Initialization:
            ```java
            data_type array_name[][] = new data_type[n][];  //n: no. of rows
            array_name[0] = new data_type[n1] //n1= no. of columns in row-1
            array_name[1] = new data_type[n2] //n2= no. of columns in row-2
            array_name[2] = new data_type[n3] //n3= no. of columns in row-3
                                .
                                .
                                .
            array_name[n-1] = new data_type[nk]  //nk=no. of columns in row-n
            ```
        2. Alternative, ways to Initialize a Jagged array :
            ```java
            int arr_name[][] = new int[][]  {
                new int[] {10, 20, 30 ,40},
                new int[] {50, 60, 70, 80, 90, 100},
                new int[] {110, 120}
            };                          
            // OR
            int[][] arr_name = {
                new int[] {10, 20, 30 ,40},
                new int[] {50, 60, 70, 80, 90, 100},
                new int[] {110, 120}
            };                      
            // OR
            int[][] arr_name = {
                {10, 20, 30 ,40},
                {50, 60, 70, 80, 90, 100},
                {110, 120}
            };
            ```

    <hr />

    4. ### Traverssing Arrays:
       1. #### 1-D Arrays:
          1. ##### Using a for loop:
              ```java
              for (int i = 0; i < arr.length; i++) {
                  System.out.println(arr[i]);
              }
              ```
          2. ##### Using a while loop:
              ```java
              int i = 0;
              while (i < arr.length) {
                  System.out.println(arr[i]);
                  i++;
              }
              ```
          3. ##### Using an enhanced for loop (for-each loop):
              ```java
              for (int element : arr) {
                  System.out.println(element);
              }
              ```
          4. ##### Using Collections iterator:
              ```java
              import java.util.ArrayList;
              import java.util.Iterator;
              import java.util.List;

              public class Main {
                public static void main(String[] args) {
                    Integer[] arr = {1, 2, 3, 4, 5};
                    List<Integer> list = new ArrayList<>();

                    for (Integer value : arr) {
                        list.add(value);
                    }

                    Iterator<Integer> iterator = list.iterator();

                    while (iterator.hasNext()) {
                        Integer element = iterator.next();
                        System.out.println(element);
                    }
                }
              }
            ```
        <hr>

       2. #### 2-D Arrays:
          1. ##### Using nested for loops:
              ```java
              for (int i = 0; i < arr.length; i++) {
                   for (int j = 0; j < arr[i].length; j++) {
                       System.out.println(arr[i][j]);
                   }
               }
              ```
          2. ##### Using nested enhanced for loops (for-each loops):
              ```java
              for (int[] row : arr) {
                   for (int element : row) {
                       System.out.println(element);
                   }
               }
              ```
          3. ##### Using the Java Streams API:
              ```java
              Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);
              ```
          4. ##### Using recursion:
              ```java
              public void traverseArray(int[][] arr, int i, int j) {
                   if (i < arr.length) {
                       if (j < arr[i].length) {
                           System.out.println(arr[i][j]);
                           traverseArray(arr, i, j + 1);
                       } else {
                           traverseArray(arr, i + 1, 0);
                       }
                   }
               }
              ```
          5. ##### Using Collections iterator:
               ```java
               import java.util.ArrayList;
               import java.util.Iterator;
               import java.util.List;

               public class Main {
                   public static void main(String[] args) {
                       Integer[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                       List<List<Integer>> list = new ArrayList<>();

                       for (Integer[] row : arr) {
                           List<Integer> subList = new ArrayList<>();
                           for (Integer value : row) {
                               subList.add(value);
                           }
                           list.add(subList);
                       }

                       Iterator<List<Integer>> outerIterator = list.iterator();

                       while (outerIterator.hasNext()) {
                           Iterator<Integer> innerIterator = outerIterator.next().iterator();
                           while (innerIterator.hasNext()) {
                               Integer element = innerIterator.next();
                               System.out.println(element);
                           }
                       }
                   }
               }
               ```
          6. ##### Using a Custom iterator:
               ```java
                import java.util.Iterator;

                    public class ArrayIterator implements Iterator<Integer> {
                        private int[][] arr;
                        private int row, col;

                        public ArrayIterator(int[][] arr) {
                            this.arr = arr;
                        }

                        @Override
                        public boolean hasNext() {
                            return row < arr.length && col < arr[row].length;
                        }

                        @Override
                        public Integer next() {
                            int value = arr[row][col];
                            col++;
                            if (col >= arr[row].length) {
                                row++;
                                col = 0;
                            }
                            return value;
                        }
                    }
                ```

<hr />
<hr />

4. ## Array Class:
   - Java provides a built-in `java.util.Arrays` class that contains various `static methods` for working with arrays.
   - Some common methods include `sorting`, `searching`, `filling`, and `converting arrays`.
   - For example:
       ```java
       import java.util.Arrays;

       int[] numbers = { 5, 2, 8, 1, 3 };
       Arrays.sort(numbers); // Sort the 'numbers' array in ascending order
       int index = Arrays.binarySearch(numbers, 5); // Search for the index of '5' in the sorted array
       ```

<hr />
<hr />

5. ## Collections Framework:

   - While arrays are fixed-size and not very flexible, Java provides the Collections Framework to work with `dynamic-sized` collections of objects.
   - The framework includes various interfaces and classes like `List`, `Set`, and `Map`.