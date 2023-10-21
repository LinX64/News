package data.util

enum class Sources(val value: String) {
    TechCrunch("top-headlines?sources=techcrunch&apiKey="),
    Business("top-headlines?country=us&category=business&apiKey="),
    WALL_STREET_JOURNAL("everything?domains=wsj.com&apiKey="),
    TESLA("everything?q=tesla&from=2023-09-21&sortBy=publishedAt&apiKey="),
    APPLE("everything?q=apple&from=2023-10-20&to=2023-10-20&sortBy=popularity&apiKey=")
}