class AuctionSystem {
    // we have userId itemId and bidId

    // we add bid for itemId by user id with amount if the same user has bid increase the bid by current 

    // so one item can have multiple bids by multiple person a person can also 
    // who have bidded to item id is imp so we can use map of treemap so we can have like 
    // item id which has mulitple bids that bids we can take the one with highest bid 
    // we will also need a map for userId and item map with ther bids 
    // so user -> then map item which is mapped to there amount 

    // so we need 2 maps atleast for now I have figured 
    // first is map to item bid and user so we can use treemap to get the fasest 
    // user to item but do we even need cost here i dont think so set would worok too 
    // ex if I put a bid user should just tell if i have that bid no we need bid to get the 

    // but in case of the of the match they need one with highest user id there really is level to this shi

    // so we map the item to bid and then among those bid too we need ones which has the highest bid we really need is map treemap of treeset 💔🙏 is that even possible 

    // and we need the userId and bid amount and item id so we also need a map where it is like user id map to item and there bid 

    Map<Integer, Map<Integer, Integer>> userToBid;

    // it has map<item ,treemap<budget<set<userid>>> so we have oike item which gives higest bid which gives the userId thats it 
    Map<Integer, TreeMap<Integer, TreeSet<Integer>>> itemToUser;

    public AuctionSystem() {
        userToBid = new HashMap<>();
        itemToUser = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int newAmount) {
        userToBid.putIfAbsent(userId, new HashMap<Integer, Integer>());
        if (userToBid.get(userId).containsKey(itemId)) {
            int oldBid = userToBid.get(userId).get(itemId);
            userToBid.get(userId).put(itemId, newAmount);

            itemToUser.get(itemId).get(oldBid).remove(userId);
            if (itemToUser.get(itemId).get(oldBid).isEmpty()) {
                itemToUser.get(itemId).remove(oldBid);
            }

            itemToUser.get(itemId).putIfAbsent(newAmount, new TreeSet<>());
            itemToUser.get(itemId).get(newAmount).add(userId);
            return ; 
        }
        userToBid.get(userId).put(itemId, newAmount);

        itemToUser.putIfAbsent(itemId, new TreeMap<Integer, TreeSet<Integer>>());
        itemToUser.get(itemId).putIfAbsent(newAmount, new TreeSet<>());
        itemToUser.get(itemId).get(newAmount).add(userId);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        int oldBid = userToBid.get(userId).get(itemId);
        userToBid.get(userId).put(itemId, newAmount);

        itemToUser.get(itemId).get(oldBid).remove(userId);
        if (itemToUser.get(itemId).get(oldBid).isEmpty()) {
            itemToUser.get(itemId).remove(oldBid);
        }

        itemToUser.get(itemId).putIfAbsent(newAmount, new TreeSet<>());
        itemToUser.get(itemId).get(newAmount).add(userId);
    }

    public void removeBid(int userId, int itemId) {
        int oldBid = userToBid.get(userId).get(itemId);
        userToBid.get(userId).remove(itemId);
        if (userToBid.get(userId).isEmpty()) {
            userToBid.remove(userId);
        }

        itemToUser.get(itemId).get(oldBid).remove(userId);
        if (itemToUser.get(itemId).get(oldBid).isEmpty()) {
            itemToUser.get(itemId).remove(oldBid);
        }
    }

    public int getHighestBidder(int itemId) {
        if (!itemToUser.containsKey(itemId))
            return -1;

        TreeMap<Integer, TreeSet<Integer>> bids = itemToUser.get(itemId);

        if (bids.isEmpty())
            return -1;

        int highestBid = bids.lastKey();
        return bids.get(highestBid).last();
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */