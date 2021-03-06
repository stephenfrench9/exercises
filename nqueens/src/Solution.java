import java.util.*;

public class Solution {

    public static List<List<String>> solveNQueens(int n) {
        List<List<Integer>> discovered_answers = new ArrayList<List<Integer>>();
        ArrayList<Integer> board = new ArrayList<Integer>(Arrays.asList());

        ArrayList<Integer> allowed  =
                new ArrayList<Integer>();

        for(int k = 0; k < n; k ++) {
            allowed.add(k);
        }

        Solution.fill_in_final(board, allowed, discovered_answers,n,0);

        List<List<String>> v = Solution.convert(discovered_answers, n);
        return v;
    }

    public static void fill_in(ArrayList<Integer> board,
                               ArrayList<Integer> allowed,
                               List<List<Integer>> answers, int n, int depth) {

        if(board.size() == n) { // the board is full of queens
            System.out.println(depth + ": base case");
            System.out.println("" + depth + ": " + "allowed = " + allowed);
            System.out.println("" + depth + ": " + "board = " + board);

            answers.add(new ArrayList<Integer>(board));
            System.out.println("" + depth + ": " + "answers = " + answers);
            System.out.println();
        } else { //iterate over all the remaining allowed values
            int size = allowed.size();
            for (int it = 0; it < size; it++) {
                System.out.println(depth + ": recursive case");
                System.out.println("" + depth + ": " + "allowed = " + allowed);
                System.out.println("" + depth + ": " + "board = " + board);
                System.out.println("" + depth + ": " + "answers = " + answers);
                System.out.println("" + depth + ": " + "index = " + it);
                System.out.println();

                int a = allowed.remove(it);
                board.add(a);
                fill_in(board, allowed, answers, n, depth+1);

                board.remove(board.size()-1);
                allowed.add(it,a);
            }
        }
    }

    public static void fill_in_final(ArrayList<Integer> board,
                               ArrayList<Integer> allowed,
                               List<List<Integer>> answers, int n, int depth) {

        if(board.size() == n) { // the board is full of queens
//            System.out.println(depth + ": base cases");
//            System.out.println("" + depth + ": " + "allowed = " + allowed);
//            System.out.println("" + depth + ": " + "board = " + board);


            answers.add(new ArrayList<Integer>(board));
//            System.out.println("" + depth + ": " + "answers = " + answers);
//            System.out.println();
        } else { //iterate over all the remaining allowed values
            int size = allowed.size();
            for (int it = 0; it < size; it++) {
//                System.out.println(depth + ": recursive case");
//                System.out.println("" + depth + ": " + "allowed = " + allowed);
//                System.out.println("" + depth + ": " + "board = " + board);
//                System.out.println("" + depth + ": " + "answers = " + answers);
//                System.out.println("" + depth + ": " + "index = " + it);
//                System.out.println();

                int candiate = allowed.remove(it);
                int next_row = board.size();
                ArrayList<Integer> forbidden = new ArrayList<Integer>();
                for(int row = 0; row < next_row; row++) {
                    int occupied = board.get(row);
                    forbidden.add(occupied + next_row - row);
                    forbidden.add(occupied + row - next_row);
                }

                if(!forbidden.contains(candiate)){
                    board.add(next_row, candiate);
                    fill_in_final(board, allowed, answers, n, depth + 1);

                    board.remove(board.size() - 1);
                    allowed.add(it, candiate);
                } else {
                    allowed.add(it, candiate);
                }
            }
        }
    }

    public static void same_boards(List<List<Integer>> discovered_answers,
                                   List<List<Integer>> actual_answers) {
        assert discovered_answers.size() == actual_answers.size();

        for(int i = 0; i < discovered_answers.size(); i++) {
            List<Integer> d = discovered_answers.get(i);
            List<Integer> a = actual_answers.get(i);
            assert d.size() == a.size();
            for(int j = 0; j < d.size(); j++) {
                assert d.get(j) == a.get(j);
            }
        }

    }

    public static List<List<String>> convert(List<List<Integer>> in, int n) {
        List<List<String>> v = new ArrayList<List<String>>();



        for (Iterator<List<Integer>> it = in.iterator(); it.hasNext(); ) {
            List<Integer> board = it.next();
            Vector<String> board_t = new Vector<String>();

            for(int i = 0; i < n; i++) {
                Integer c0 = board.get(i);
                String row = "";
                for (int c = 0; c < n; c++) {
                    if(c == c0) {
                        row = row + "Q";
                    } else {
                        row = row + ".";
                    }
                }
                board_t.add(row);
            }
            v.add(board_t);

        }
        return v;
    }
}
