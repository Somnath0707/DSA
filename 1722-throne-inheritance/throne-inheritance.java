class ThroneInheritance {

    Map<String, List<String>> tree;
    Set<String> dead;
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        tree = new HashMap<>();
        dead = new HashSet<>();
        tree.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        tree.putIfAbsent(parentName, new ArrayList<>());
        tree.get(parentName).add(childName);
        tree.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(king, result);
        return result;
    }

    private void dfs(String person, List<String> result) {
        if (!dead.contains(person)) {
            result.add(person);
        }

        for (String child : tree.get(person)) {
            dfs(child, result);
        }
    }
}