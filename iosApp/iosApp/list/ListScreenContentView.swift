import SwiftUI
import ComposeApp

extension Restaurant : Identifiable {}

struct ListScreenContentView : View {
    var viewModel: ListViewModel
    var onRestaurantClick: (Restaurant) -> Void

    @State var restaurants: [Restaurant] = []

    var body: some View {
        List(restaurants) { restaurant in
            RestaurantListItemView(
                restaurant: restaurant,
                onClick: { self.onRestaurantClick(restaurant) }
            )
        }.collect(flow: viewModel.restaurants, into: $restaurants)
    }
}
