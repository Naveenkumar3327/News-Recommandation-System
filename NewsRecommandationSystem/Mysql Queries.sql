create database NewsRecommendationDB;
use NewsRecommendationDB;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE articles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    category VARCHAR(255) NOT NULL
);
CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    article_id INT NOT NULL,
    rating INT NOT NULL,
    feedback_text TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (article_id) REFERENCES articles(id)
);
INSERT INTO articles (title, content, category) VALUES
('Football: The Biggest Matches of the Year', 'A look at the top football matches that will define the season.', 'Sports'),
('Olympics 2024 Preview', 'The next Olympic Games promises to be full of surprises and records.', 'Sports'),
('Tennis: Serena Williams'' Impact', 'Serena Williams has transformed women’s tennis like no other.', 'Sports'),
('NBA Playoffs Predictions', 'An analysis of the NBA teams most likely to make it to the finals this season.', 'Sports'),
('Formula 1: Who Will Win the Championship?', 'A breakdown of the top drivers and teams for the 2024 F1 season.', 'Sports'),
('World Cup: Historical Moments', 'Exploring the unforgettable moments of FIFA World Cup history.', 'Sports'),
('The Rise of eSports', 'How eSports has grown to become a multi-billion dollar industry.', 'Sports'),
('Top 10 Footballers of All Time', 'A list of the greatest footballers to ever play the game.', 'Sports'),
('The Future of Women’s Soccer', 'Women’s soccer is growing rapidly, but what is next for the sport?', 'Sports'),
('The Importance of Sports in Mental Health', 'How sports and physical activity can improve mental health.', 'Sports');

INSERT INTO articles (title, content, category) VALUES
('The 2024 US Presidential Election', 'A preview of the candidates and key issues for the upcoming election.', 'Politics'),
('Brexit: The Aftermath', 'An in-depth analysis of how Brexit has reshaped the UK and its relations with Europe.', 'Politics'),
('China’s Role in Global Politics', 'How China’s growing influence is changing the world order.', 'Politics'),
('The Political Landscape in India', 'An overview of India’s current political situation and upcoming elections.', 'Politics'),
('Political Polarization in the US', 'How division between political parties is impacting the American democracy.', 'Politics'),
('Climate Change and Political Action', 'What governments are doing (or not doing) to tackle climate change.', 'Politics'),
('The Impact of Social Media on Politics', 'How social media has influenced political campaigns and public opinion.', 'Politics'),
('Voting Rights and Disenfranchisement', 'A look at the ongoing struggle for voting rights in many countries.', 'Politics'),
('The Rise of Populist Movements', 'Understanding the global trend of populism and its political consequences.', 'Politics'),
('International Relations in the 21st Century', 'How diplomacy and international conflicts are shaping the future.', 'Politics');

INSERT INTO articles (title, content, category) VALUES
('Stock Market Trends to Watch in 2024', 'The top trends investors should keep an eye on this year.', 'Stock Market'),
('Tech Stocks That Will Dominate the Market', 'Why tech companies will continue to lead the stock market in 2024.', 'Stock Market'),
('How to Build a Strong Stock Portfolio', 'Tips on how to diversify and manage your investments wisely.', 'Stock Market'),
('Cryptocurrency: A Booming Investment', 'Is cryptocurrency still a good investment in the current market?', 'Stock Market'),
('The Impact of Global Events on Stock Markets', 'How geopolitical events, like wars and elections, affect stock prices.', 'Stock Market'),
('Stock Market Crashes and How to Survive Them', 'How to handle and protect your investments during market downturns.', 'Stock Market'),
('ETFs vs Mutual Funds: What’s the Best Choice?', 'A comparison of exchange-traded funds and mutual funds for investors.', 'Stock Market'),
('Dividend Stocks to Invest In', 'The best dividend-paying stocks for long-term investment returns.', 'Stock Market'),
('How Interest Rates Affect Stock Prices', 'Understanding the relationship between central bank rates and stock prices.', 'Stock Market'),
('The Future of the Stock Market Post-Pandemic', 'How the stock market will evolve after the COVID-19 pandemic.', 'Stock Market');
INSERT INTO articles (title, content, category) VALUES
('The Future of AI and Automation', 'Exploring how AI is transforming industries and our daily lives.', 'General'),
('Climate Change and Its Impact on Agriculture', 'How climate change is affecting global food production and supply.', 'General'),
('The Rise of Remote Work: A New Normal?', 'How the COVID-19 pandemic has permanently changed the way we work.', 'General'),
('The Importance of Mental Health Awareness', 'Why mental health should be prioritized in modern society.', 'General'),
('Sustainable Living: Small Changes for a Better World', 'How individuals can reduce their carbon footprint and live sustainably.', 'General'),
('The Digital Transformation of Healthcare', 'How technology is improving patient care and streamlining healthcare systems.', 'General'),
('Smart Cities: The Future of Urban Living', 'How technology is revolutionizing cities for smarter, more sustainable living.', 'General'),
('Virtual Reality: A Game-Changer for Education', 'The role of VR in revolutionizing the way we learn.', 'General'),
('The Pros and Cons of Genetic Engineering', 'A deep dive into the benefits and risks of genetic engineering in humans and agriculture.', 'General'),
('Space Exploration: What’s Next After Mars?', 'What the future holds for space exploration beyond Mars.', 'General');

INSERT INTO articles (title, content, category) VALUES
('The Housing Market in 2024', 'What to expect from the housing market this year.', 'Real Estate'),
('The Impact of Remote Work on Real Estate', 'How the shift to remote work is influencing home-buying trends.', 'Real Estate'),
('How to Buy Your First Home', 'A step-by-step guide for first-time homebuyers in 2024.', 'Real Estate'),
('The Rise of Luxury Real Estate in Urban Areas', 'Why luxury real estate continues to thrive in major cities.', 'Real Estate'),
('Sustainable Architecture and Green Homes', 'How green architecture is shaping the future of real estate.', 'Real Estate'),
('Investing in Commercial Real Estate', 'Why commercial real estate remains a stable investment in uncertain times.', 'Real Estate'),
('Real Estate Trends in Major Global Cities', 'The latest trends in real estate markets in cities like New York, London, and Tokyo.', 'Real Estate'),
('The Future of Rental Properties', 'How rental markets are evolving and what landlords need to know.', 'Real Estate'),
('Real Estate as a Wealth-Building Tool', 'How real estate can be used to build long-term wealth and security.', 'Real Estate'),
('The Impact of Technology on Real Estate', 'How AI and data analytics are revolutionizing real estate transactions.', 'Real Estate');

INSERT INTO articles (title, content, category) VALUES
('10 Hilarious Facts About Animals', 'Discover some of the funniest and most surprising facts about the animal kingdom.', 'Funny Facts'),
('The Weirdest Laws from Around the World', 'From banning chewing gum to banning marriages between cousins – these are real laws.', 'Funny Facts'),
('Unbelievable World Records', 'The world is full of bizarre and funny records that will leave you laughing.', 'Funny Facts'),
('Strange Foods People Actually Eat', 'Would you dare to try these weird dishes from around the world?', 'Funny Facts'),
('The Funniest Tweets Ever', 'Here are some of the funniest tweets you’ll ever read on Twitter.', 'Funny Facts'),
('Historical Moments That Are Hard to Believe', 'These historical events will make you question everything you thought you knew.', 'Funny Facts'),
('The Funniest Things Kids Have Said', 'Children’s honesty and creativity make for the funniest quotes.', 'Funny Facts'),
('Amazing Coincidences That Will Blow Your Mind', 'Unbelievable stories of random coincidences that are way too weird to be true.', 'Funny Facts'),
('Crazy Superstitions People Believe', 'From broken mirrors to black cats – these are some odd superstitions people follow.', 'Funny Facts'),
('Jokes That Will Make You Laugh Out Loud', 'These jokes are guaranteed to bring a smile to your face!', 'Funny Facts');

select * from users;

select * from feedback;

select * from articles;






