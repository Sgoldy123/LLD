import java.util.*;

class Buyer {
    String name;
    int participationCount;
    boolean isPreferred;

    public Buyer(String name) {
        this.name = name;
        this.participationCount = 0;
        this.isPreferred = false;
    }

    public void incrementParticipation() {
        participationCount++;
        if (participationCount > 2) {
            isPreferred = true;
        }
    }
}

class Seller {
    String name;

    public Seller(String name) {
        this.name = name;
    }
}

class Auction {
    String id;
    int lowestBidLimit;
    int highestBidLimit;
    int participationCost;
    Seller seller;
    Map<Buyer, Integer> bids;
    boolean isClosed;

    public Auction(String id, int lowestBidLimit, int highestBidLimit, int participationCost, Seller seller) {
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        this.bids = new HashMap<>();
        this.isClosed = false;
    }

    public boolean isValidBid(int amount) {
        return amount >= lowestBidLimit && amount <= highestBidLimit;
    }

    public void addBid(Buyer buyer, int amount) {
        if (!isClosed && isValidBid(amount)) {
            bids.put(buyer, amount);
            buyer.incrementParticipation();
        } else {
            System.out.println("Invalid bid or auction closed.");
        }
    }

    public void updateBid(Buyer buyer, int amount) {
        if (!isClosed && isValidBid(amount)) {
            bids.put(buyer, amount);
        } else {
            System.out.println("Invalid bid or auction closed.");
        }
    }

    public void withdrawBid(Buyer buyer) {
        if (!isClosed) {
            bids.remove(buyer);
        } else {
            System.out.println("Auction closed.");
        }
    }

    public Buyer closeAuction() {
        isClosed = true;
        return determineWinner();
    }

    private Buyer determineWinner() {
        Map<Integer, List<Buyer>> bidFrequency = new HashMap<>();
        for (Map.Entry<Buyer, Integer> entry : bids.entrySet()) {
            int bidAmount = entry.getValue();
            Buyer buyer = entry.getKey();
            bidFrequency.computeIfAbsent(bidAmount, k -> new ArrayList<>()).add(buyer);
        }

        int highestUniqueBid = -1;
        Buyer winner = null;

        for (Map.Entry<Integer, List<Buyer>> entry : bidFrequency.entrySet()) {
            if (entry.getValue().size() == 1) {
                if (entry.getKey() > highestUniqueBid) {
                    highestUniqueBid = entry.getKey();
                    winner = entry.getValue().get(0);
                }
            }
        }

        return winner;
    }

    public double calculateProfitLoss() {
        int totalBidders = bids.size();
        double participationRevenue = totalBidders * 0.2 * participationCost;

        Buyer winner = determineWinner();
        if (winner == null) {
            return participationRevenue;
        }

        int winningBid = bids.get(winner);
        double averageBidLimit = (lowestBidLimit + highestBidLimit) / 2.0;
        return winningBid + participationRevenue - averageBidLimit;
    }
}

class AuctionSystem {
    Map<String, Buyer> buyers;
    Map<String, Seller> sellers;
    Map<String, Auction> auctions;

    public AuctionSystem() {
        this.buyers = new HashMap<>();
        this.sellers = new HashMap<>();
        this.auctions = new HashMap<>();
    }

    public void addBuyer(String name) {
        buyers.put(name, new Buyer(name));
        System.out.println("Buyer " + name + " added.");
    }

    public void addSeller(String name) {
        sellers.put(name, new Seller(name));
        System.out.println("Seller " + name + " added.");
    }

    public void createAuction(String id, int lowestBidLimit, int highestBidLimit, int participationCost, String sellerName) {
        Seller seller = sellers.get(sellerName);
        if (seller != null) {
            auctions.put(id, new Auction(id, lowestBidLimit, highestBidLimit, participationCost, seller));
            System.out.println("Auction " + id + " created.");
        } else {
            System.out.println("Seller not found.");
        }
    }

    public void createBid(String buyerName, String auctionId, int amount) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            auction.addBid(buyer, amount);
        } else {
            System.out.println("Buyer or auction not found.");
        }
    }

    public void updateBid(String buyerName, String auctionId, int amount) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            auction.updateBid(buyer, amount);
        } else {
            System.out.println("Buyer or auction not found.");
        }
    }

    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            auction.withdrawBid(buyer);
        } else {
            System.out.println("Buyer or auction not found.");
        }
    }

    public void closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction != null) {
            Buyer winner = auction.closeAuction();
            if (winner != null) {
                System.out.println("Auction " + auctionId + " closed. Winner: " + winner.name);
            } else {
                System.out.println("Auction " + auctionId + " closed. No winner.");
            }
        } else {
            System.out.println("Auction not found.");
        }
    }

    public void getProfit(String sellerName, String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction != null && auction.seller.name.equals(sellerName)) {
            double profitLoss = auction.calculateProfitLoss();
            System.out.println("Profit/Loss for seller " + sellerName + " in auction " + auctionId + ": " + profitLoss);
        } else {
            System.out.println("Auction or seller not found.");
        }
    }
}

public class DeepSeek {
    public static void main(String[] args) {
        AuctionSystem system = new AuctionSystem();

        // Test Case 1
        system.addBuyer("buyer1");
        system.addBuyer("buyer2");
        system.addBuyer("buyer3");
        system.addSeller("seller1");
        system.createAuction("A1", 10, 50, 1, "seller1");
        system.createBid("buyer1", "A1", 17);
        system.createBid("buyer2", "A1", 15);
        system.updateBid("buyer2", "A1", 19);
        system.createBid("buyer3", "A1", 19);
        system.closeAuction("A1");
        system.getProfit("seller1", "A1");

        // Test Case 2
        system.addSeller("seller2");
        system.createAuction("A2", 5, 20, 2, "seller2");
        system.createBid("buyer3", "A2", 25); // Should fail
        system.createBid("buyer2", "A2", 5);
        system.withdrawBid("buyer2", "A2");
        system.closeAuction("A2");
        system.getProfit("seller2", "A2");
    }
}