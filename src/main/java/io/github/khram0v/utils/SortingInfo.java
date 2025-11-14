package io.github.khram0v.utils;

import java.util.List;

public record SortingInfo(
        String name,
        String description,
        String complexityBest,
        String complexityAverage,
        String complexityWorst
) {
    public static void printSortingInfo() {
        for (SortingInfo info : sortingInfos()) {
            printInfo(info);
        }
    }

    private static List<SortingInfo> sortingInfos() {
        return List.of(
                new SortingInfo("Bubble Sort",
                        """
                        This is a comparison-based algorithm. It means that it's based on element comparing.
                        It repeatedly steps through the list, compares adjacent elements and swaps them if
                        they are in wrong order. And it repeats until the list is sorted.
                        """,
                        "O(n)",
                        "O(n^2)",
                        "O(n^2)"
                ),
                new SortingInfo("Selection Sort",
                        """
                        This is a comparison-based algorithm. It divides the list into a sorted and unsorted
                        region. It repeatedly selects smallest (or largest) element from unsorted region and
                        moves it to the end of the sorted region.
                        """,
                        "O(n^2)",
                        "O(n^2)",
                        "O(n^2)"
                ),
                new SortingInfo("Insertion Sort",
                        """
                        This is a comparison-based algorithm. It works by building the sorted output one item
                        at a time. For each element, the algorithm compares it with the elements in the
                        sorted region, shifting them right if they are greater than the current element,
                        and inserts the element in its correct position.
                        """,
                        "O(n)",
                        "O(n^2)",
                        "O(n^2)"
                ),
                new SortingInfo("Merge Sort",
                        """
                        This is a divide-and-conquer algorithm. It recursively divides the list into two halves,
                        sorts each half, and the then merges the sorted halves to produce the final output.
                        """,
                        "O(n*log(n))",
                        "O(n*log(n))",
                        "O(n*log(n))"
                ),
                new SortingInfo("Quick Sort",
                        """
                        This is a divide-and-conquer algorithm. It works by selecting a ‘pivot’ element from
                        the list and partitioning the other elements into two groups, according to whether
                        they are less or greater than the pivot. These sub-lists are sorted recursively.
                        """,
                        "O(n*log(n))",
                        "O(n*log(n))",
                        "O(n^2)"
                )
        );
    }

    private static void printInfo(SortingInfo info) {
        System.out.println("\n" + info.name());
        System.out.println(info.description());
        System.out.println("Best: " + info.complexityBest());
        System.out.println("Average: " + info.complexityAverage());
        System.out.println("Worst: " + info.complexityWorst());
    }
}
