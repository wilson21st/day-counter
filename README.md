# About this project

* Java 8 Eclipse with Maven
* Three different solutions:
    * Solution 1 (O(n)): count days from the samller one, stop until both dates are identical.
    * Solution 2 (O(1)): based on the solution 1, count days from 01/01/1901 to 31/01/2999, then save the date and the counted days into a hash map. This map is kept in memory and can be used for further counting purpose.
    * Solution 3 (O(1): according to the formula on internet, both dates are converted from the Gregorian calendar to the Julian day number, followed by a substraction on the numbers.
* Compile & test: mvn clean package
* Run application: java -jar daycounter.jar 03/01/1989 03/08/1983

# Result

* Test dates: 03/01/1989 03/08/1983
* Repeat the process 500,000 times

```
Solution1: Days=1979, Time=5273(ms)
Solution2: Days=1979, Time=78(ms)
Solution3: Days=1979, Time=31(ms)
```

# Ideas
* The first solution is very slow if being used many times.
* The second one is based on the first solution, plus a note keeping all the previous hard works - it improves the speed by accessing the days via hashed key in the map.
* The third one is the fastest solution, but I would spend more time on the formular than writing the code if there is no Google.
