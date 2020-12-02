package restaurant.business;

public class OpenItem {
    private static int selectedCategory;
    private static int itemId;

    public static void selectCategory(int categoryId) {
        selectedCategory = categoryId;
    }

    public static void selectItem(int inputItemId) {
         itemId = inputItemId;
    }

    public static int getSelectedCategory() {
        return selectedCategory;
    }

    public static int getSelectedItem() {
        return itemId;
    }
}
