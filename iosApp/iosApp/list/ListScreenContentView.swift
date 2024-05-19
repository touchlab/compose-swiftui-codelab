import SwiftUI
import ComposeApp

extension Restaurant : Identifiable {}

struct ListScreenContentView : View {
    var viewModel: ListViewModel
    var onRestaurantClick: (Restaurant) -> Void

    // TODO: state observation
    @State var restaurants: [Restaurant] = []

    var body: some View {
        List(restaurants) { restaurant in
            RestaurantListItemView(
                restaurant: restaurant,
                onClick: { self.onRestaurantClick(restaurant) }
            )
        }
    }
}
