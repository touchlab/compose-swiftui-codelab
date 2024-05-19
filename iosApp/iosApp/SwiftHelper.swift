import SwiftUI

extension View {
    @MainActor
    func collectWithLifecycle<S : AsyncSequence, T>(_ sequence: S, binding: Binding<T>) -> some View where S.Element == T {
        task {
            do {
                for try await item in sequence {
                    binding.wrappedValue = item
                }
            }catch {
                print("error while collecting async sequence")
            }
        }
    }
}
