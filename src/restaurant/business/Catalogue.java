package restaurant.business;

import java.util.ArrayList;

public class Catalogue {
    private static int numberOfCatalogueItems;
    private static int numberOfCategories;

    private static ArrayList<CatalogueItem> itemsCatalogue;
    private static ArrayList<CategoryItem> categories;

    public static class CatalogueItem{
        int categoryId;
        String name;
        int price;

        public CatalogueItem(String inputCategoryId, String inputName, int inputPrice) {
            categoryId = Integer.parseInt(inputCategoryId);
            name = inputName;
            price = inputPrice;
        }

        public int getCategoryId() {return categoryId;}

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    public static class CategoryItem{
        String name;

        public CategoryItem(String nameOfCategory) {
            name = nameOfCategory;
        }

        public String getName() {return name;}
    }

    public static void init() {
        itemsCatalogue = new ArrayList();
        categories = new ArrayList();

        fillCatalogue();

        numberOfCatalogueItems = itemsCatalogue.size();
        numberOfCategories = categories.size();
    }

    public static String getName(int inputId) {
        return itemsCatalogue.get(inputId).getName();
    }

    public static int getPrice(int inputId) {
        return itemsCatalogue.get(inputId).getPrice();
    }

    public static String getCategoryName(int categoryId) {
        return categories.get(categoryId).getName();
    }

    public static int getNumberOfCatalogueItems() {
        return numberOfCatalogueItems;
    }

    public static int getNumberOfCategories() {
        return numberOfCategories;
    }

    public static String[] getAllCategories() {
        String[] result = new String[getNumberOfCategories()];
        for (int i=0;i<getNumberOfCategories();i++) {
            result[i] = getCategoryName(i);
        }
        return result;
    }

    public static ArrayList<Integer> getCategoryProducts(int categoryId) {
        ArrayList<Integer> result = new ArrayList();
        for (int i=0;i<getNumberOfCatalogueItems();i++) {
            if (itemsCatalogue.get(i).getCategoryId()==categoryId) {
                result.add(i);
            }
        }
        return result;
    }

    //fake loader
    private static void fillCatalogue() {
        itemsCatalogue.add(new CatalogueItem("0","Daily offer",45));
        itemsCatalogue.add(new CatalogueItem("0","Cabbage soup",50));
        itemsCatalogue.add(new CatalogueItem("0","Goulash soup",59));
        itemsCatalogue.add(new CatalogueItem("0","Fish soup",65));
        itemsCatalogue.add(new CatalogueItem("1","Roasted pork",140));
        itemsCatalogue.add(new CatalogueItem("1","Spare ribs",220));
        itemsCatalogue.add(new CatalogueItem("1","Duck breast",200));
        itemsCatalogue.add(new CatalogueItem("1","Chilli goulash",180));
        itemsCatalogue.add(new CatalogueItem("2","Schnitzel",140));
        itemsCatalogue.add(new CatalogueItem("2","Beefsteak on grill",220));
        itemsCatalogue.add(new CatalogueItem("2","Pork medaillon",170));
        itemsCatalogue.add(new CatalogueItem("2","Grilled chicken breast",140));
        itemsCatalogue.add(new CatalogueItem("3","Tiramisu",70));
        itemsCatalogue.add(new CatalogueItem("3","Pancakes",60));
        itemsCatalogue.add(new CatalogueItem("3","Strawberry pudding",50));
        itemsCatalogue.add(new CatalogueItem("3","Hot raspberries",70));
        itemsCatalogue.add(new CatalogueItem("4","Sparkling water",30));
        itemsCatalogue.add(new CatalogueItem("4","Still water",30));
        itemsCatalogue.add(new CatalogueItem("4","Coke",30));
        itemsCatalogue.add(new CatalogueItem("4","Sprite",35));
        itemsCatalogue.add(new CatalogueItem("4","Orange juice",35));
        itemsCatalogue.add(new CatalogueItem("4","Espresso",35));
        itemsCatalogue.add(new CatalogueItem("4","Irish coffee",35));
        itemsCatalogue.add(new CatalogueItem("4","Red bull",80));
        itemsCatalogue.add(new CatalogueItem("5","Pilsner",45));
        itemsCatalogue.add(new CatalogueItem("5","Radegast",40));
        itemsCatalogue.add(new CatalogueItem("5","Gin",60));
        itemsCatalogue.add(new CatalogueItem("5","Vodka",60));
        itemsCatalogue.add(new CatalogueItem("5","Whiskey",70));
        itemsCatalogue.add(new CatalogueItem("5","Absinth",80));
        itemsCatalogue.add(new CatalogueItem("5","Moonshine cocktail",109));

        categories.add(new CategoryItem("Soups"));
        categories.add(new CategoryItem("Specialities"));
        categories.add(new CategoryItem("Main dishes"));
        categories.add(new CategoryItem("Desserts"));
        categories.add(new CategoryItem("Non-alcoholic"));
        categories.add(new CategoryItem("Alcoholic"));
    }
}
