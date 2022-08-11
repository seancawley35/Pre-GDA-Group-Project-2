public static String getHighScoreMessage() {
    // Create Array to hold the scores
    // TODO -- Use TreeMap instead for connecting unique scores to a timestamp or name.
    long[][] highScoreArray = new long[5000][2];
    TreeMap<Long, Long> score_map = new TreeMap<Long, Long>();

    File fileObj = new File("/home/seancawley/JavaFiles/GroupProject2/GTA-Game/src/assets/gta_high_scores.csv");



    // Read the local CSV file
    try {
        // File fileObj = new File("/home/seancawley/JavaFiles/GroupProject2/GTA-Game/src/assets/gta_high_scores.csv");
        Scanner myScanner = new Scanner(fileObj);
        myScanner.useDelimiter("\\n|,|\\s*\\$"); // Treats commas and whitespace as delimiters to read the CSV
        // Fill the score Array using the CSV
        for(int i = 0; myScanner.hasNext(); i++) {
            for(int a = 0; a <= 1; a++) {
                highScoreArray[i][a] = ((long)Long.parseLong(myScanner.next().trim()));
                //score_map.put(Long.valueOf(i),Long.valueOf(a));
            }
        }
        myScanner.close();
    } catch (FileNotFoundException e) {
        System.out.println(e);
    }



    //input scores into Treemap
    for(int i = 0; i < highScoreArray.length; i++){
        score_map.put(highScoreArray[i][0], highScoreArray[i][1]);
    }
    //FOR TESTING: REMOVE LATER
    //testing Treemap contents
    System.out.println("TreeMap: " + score_map);
    //Map with decedning order, delete if not needed
    NavigableMap<Long, Long> nm= new TreeMap<Long, Long>();
    nm = score_map.descendingMap();
    System.out.println("NewMap: " + nm);

    //return top three scores 
    int N = 3;
    int j = 0;
    String message;
    message = "<html> Final Score: <b>" + money + "</b><br>";
    for (Map.Entry entry : score_map.descendingMap().entrySet()) {
        if (j++ < N) {
            // System.out.println("Key Value " + entry.getKey());
            // System.out.println("Value " + entry.getValue());
            message += (j + "<u>st place</u>: <b>" + entry.getKey() + "</b> on " + 
            entry.getValue() + "<br>");
            // if (money > entry.getKey()) {
            //     message += "<i>CONGRATS! That's a new high score. You are top 3 all time</i><br>";;
            // }
            //  else{
            //     message += "<i>Your score is not top 3 all time</i><br>";
            // }
            //System.out.println(message);

        }
    }
   

    //make array linked list
    //try for smarter insertion
    





    // Sort Array in ascending order to easily get the highest scores
    // Note: this shouldn't be needed with a TreeMap
    //Arrays.sort(highScoreArray, Comparator.comparingDouble(a -> a[0]));
    //Get the top 3 scores

    // Set<Map.Entry<Long, Long> > entrySet = nm.entrySet();
    // Map.Entry<Long, Long>[] entryArray= entrySet.toArray(new Map.Entry[entrySet.size()]);
    // System.out.println(entryArray);
    
   
    //UNCHECK if does not work
    // int score1 = (int) highScoreArray[highScoreArray.length - 1][0];
    // Date date1 = new Date(new Timestamp(highScoreArray[highScoreArray.length - 1][1]).getTime());
    // String date1Short = date1.toString().substring(4, 10);
    // int score2 = (int) highScoreArray[highScoreArray.length - 2][0];
    // Date date2 = new Date(new Timestamp(highScoreArray[highScoreArray.length - 2][1]).getTime());
    // String date2Short = date2.toString().substring(4, 10);
    // int score3 = (int) highScoreArray[highScoreArray.length - 3][0];
    // Date date3 = new Date(new Timestamp(highScoreArray[highScoreArray.length - 3][1]).getTime());
    // String date3Short = date3.toString().substring(4, 10);

  


   
    // Special message if the player reached a top 3 high score
    // String message;
    // message = "<html> Final Score: <b>" + money + "</b><br>";
    //UNCHECK if does not work
    // if (money > score1) {
    //     message += "CONGRATS! You have the all time best score! <br>";
    // }
    // else if (money > score3) {
    //     message += "CONGRATS! That's a new high score. You are top 3 all time <br>";
    // } else{
    //     message += "<i>Your score is not top 3 all time</i><br>";
    // }
    // // Add the top 3 high scores
    // message += ("<u>1st place</u>: <b>" + score1 + "</b> on " + date1Short + "<br>");
    // message += ("<u>2nd place</u>: <b>" + score2 + "</b> on " + date2Short + "<br>");
    // message += ("<u>3rd place</u>: <b>" + score3 + "</b> on " + date3Short + "</html>");

    return message;
}