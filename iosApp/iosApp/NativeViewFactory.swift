import Foundation
import SwiftUI
import ComposeApp
import UIKit

class iOSNativeViewFactory : NativeViewFactory {
    static var shared = iOSNativeViewFactory()

    func createMapView(
        placeName: String,
        coordinate: MapCoordinates
    ) -> UIViewController {
        let mapView = NativeMapView(placeName: placeName, coordinate: coordinate)
        return UIHostingController(rootView: mapView)
    }

    func createListScreenView(
        listViewModel: ListViewModel,
        onRestaurantClick: @escaping (Restaurant) -> Void
    ) -> UIViewController {
        let listScreenView = ListScreenContentView(viewModel: listViewModel, onRestaurantClick: onRestaurantClick)
        return UIHostingController(rootView: listScreenView)
    }
}
